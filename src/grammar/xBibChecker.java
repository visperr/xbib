package grammar;

import exception.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import representation.*;
import tool.writeMode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;


public class xBibChecker extends xbibBaseListener {

    xBibCommands commands;
    Stack<Object> mem;
    Stack<Item> items;

    JSONObject allowedData;

    writeMode writeMode;

    Category currentCategory;

    boolean errorFlag = false;
    Stack<String> expectedTypes;

    private List<String> errors;

    public xBibCommands run(ParseTree tree, writeMode writeMode) throws ParseException {
        this.errors = new ArrayList<>();
        this.expectedTypes = new Stack<>();

        this.writeMode = writeMode;

        try {
            InputStream in = getClass().getResourceAsStream("/data/allowed.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            Object ob = new JSONParser().parse(reader);
            allowedData = (JSONObject) ob;
        } catch (IOException | org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }

        new ParseTreeWalker().walk(this, tree);
        if (hasErrors()) {
            throw new ParseException(getErrors()); 
        }

        return this.commands;
    }

    boolean hasErrors() {
        return !getErrors().equals("");
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public String getErrors() {
        if (errors.size() == 0)
            return "";
        
        StringBuilder res = new StringBuilder();
        for (String er : this.errors)
            res.append(ANSI_RED).append(er).append(",\n");
        res.replace(res.length()-2,res.length(), ANSI_RESET);
        
        return res.toString();
    }

    private void addError(ParserRuleContext node, String message,
                          Object... args) {

        int line = node.getStart().getLine();
        int column = node.getStart().getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }


    int countTerminalArguments(xbibParser.ArgumentContext t) {
        if (t.primitive() != null) return 1;
        int r = 0;
        for (xbibParser.ArgumentContext a : t.argument()) r += countTerminalArguments(a);
        return r;
    }

    @Override
    public void enterMain(xbibParser.MainContext ctx) {
        commands = new xBibCommands();
        mem = new Stack<>();
        items = new Stack<>();
    }

    @Override
    public void exitFieldCommand(xbibParser.FieldCommandContext ctx) {
        ArrayList<Object> arguments = new ArrayList<>();
        ArrayList<Object> actions = new ArrayList<>();

        boolean foundError = false;

        if (ctx.argument(0).getChildCount() == 0 || ctx.argument(1).getChildCount() == 0) {
            addError(ctx, "Field should have 2 arguments.");
            foundError = true;
        }

        JSONArray allowed = (JSONArray) allowedData.get("field");

        for (int x = 0; x < countTerminalArguments(ctx.argument(1)); x++) {

            boolean foundFun = false;
            String action = mem.pop().toString();

            for (Object f : allowed) {
                JSONObject fun = (JSONObject) f;

                if (fun.get("function").equals(action)) {
                    foundFun = true;
                    break;
                }
            }

            if (foundFun) {
                actions.add(action);
            } else {
                foundError = true;
                addError(ctx, "Action %s does not exist", action);
            }
        }
        for (int x = 0; x < countTerminalArguments(ctx.argument(0)); x++) {
            String arg = mem.pop().toString();

            errorFlag = false;
            checkType(ctx, "Word", arg);
            foundError = errorFlag || foundError;

            errorFlag = false;

            if (!foundError)
                arguments.add(arg);
        }

        if (!foundError)
            commands.getFields().add(new Field(arguments, actions));
    }

    JSONObject getFunction(String functionName) {
        for (Object obj : (JSONArray) allowedData.get(currentCategory.toString())) {
            JSONObject function = (JSONObject) obj;

            if (function.get("function").toString().equals(functionName))
                return function;
        }
        return null;
    }

    void fillExpectedTypes(JSONObject fun, xbibParser.ArgumentContext argument) {
        int amountOfArguments = countTerminalArguments(argument);

        JSONArray arguments = (JSONArray) fun.get("arguments");

        if (arguments.size() == 1 && arguments.get(0).getClass().equals(JSONObject.class)
                && ((JSONObject) arguments.get(0)).get("array") != null) {

            String type = ((JSONObject) arguments.get(0)).get("array").toString();
            for (int i = 0; i < amountOfArguments; i++)
                expectedTypes.add(0, type);
        } else {

            if (amountOfArguments != arguments.size())
                addError(argument, "The amount of arguments provided (%d) does does not match the function (%d)", amountOfArguments, arguments.size());

            for (Object arg : arguments) {
                if (arg.getClass().equals(JSONObject.class) && (((JSONObject) arg).get("enum") != null)) {
                    StringBuilder enumVal = new StringBuilder();
                    enumVal.append("enum:");
                    for (Object en : (JSONArray) ((JSONObject) arg).get("enum")) {
                        enumVal.append(en.toString()).append(",");
                    }
                    enumVal.replace(enumVal.length() - 1, enumVal.length(), "");
                    expectedTypes.add(0, enumVal.toString());
                } else {
                    expectedTypes.add(0, arg.toString());
                }
            }
        }
    }

    void checkType(ParserRuleContext ctx, String argType, String arg) {
        if (argType.startsWith("enum:")) {
            List<String> vals = List.of(argType.replace("enum:", "").split(","));
            if (!vals.contains(arg)) {
                addError(ctx, "The enumerator %s can only be of types %s", arg, vals.toString());
            }
        } else {
            switch (argType) {
                case "Word":
                    if (arg.charAt(0) != '\'' && arg.charAt(arg.length() - 1) != '\'') {
                        addError(ctx, "The argument %s should be a word (enclosed in single quotes)", arg);
                        errorFlag = true;
                    }
                    break;
                case "Integer":
                    try {
                        Integer.parseInt(arg);
                    } catch (NumberFormatException e) {
                        addError(ctx, "The argument %s should be an integer", arg);
                        errorFlag = true;
                    }
                    break;
            }
        }
    }

    @Override
    public void exitSetItem(xbibParser.SetItemContext ctx) {
        ArrayList<Object> arguments = new ArrayList<>();
        while (!mem.isEmpty()) {
            arguments.add(0, mem.pop());
        }

        if (!errorFlag)
            currentCategory.addItem(new Assign(ctx.value.getText(), arguments));
        errorFlag = false;
    }

    @Override
    public void exitActionItem(xbibParser.ActionItemContext ctx) {
        ArrayList<Object> arguments = new ArrayList<>();
        while (!mem.isEmpty()) {
            arguments.add(0, mem.pop());
        }

        if (!errorFlag)
            currentCategory.addItem(new Action(ctx.function.getText(), arguments));
        errorFlag = false;
    }

    @Override
    public void exitFlagItem(xbibParser.FlagItemContext ctx) {
        if (ctx.flag == null) {
            return;
        }
        Boolean val = ctx.call.getText().equals("enable");

        if (!errorFlag)
            currentCategory.addItem(new Flag(ctx.flag.getText(), val));
        errorFlag = false;
    }

    @Override
    public void enterActionItem(xbibParser.ActionItemContext ctx) {
        JSONObject fun = getFunction(ctx.function.getText());

        if (fun != null)
            fillExpectedTypes(fun, ctx.argument());
        else {
            addError(ctx, "The function %s does not exist in the current context", ctx.function.getText());
        }
    }

    @Override
    public void enterSetItem(xbibParser.SetItemContext ctx) {
        JSONObject fun = getFunction(ctx.value.getText());

        if (fun != null)
            fillExpectedTypes(fun, ctx.argument());
        else {
            addError(ctx, "The function %s does not exist in the current context", ctx.value.getText());
        }
    }

    @Override
    public void exitPrimitive(xbibParser.PrimitiveContext ctx) {
        if (!expectedTypes.isEmpty())
            checkType(ctx, expectedTypes.pop(), ctx.getText());
        mem.push(ctx.getText());
    }

    @Override
    public void enterCategoryCommand(xbibParser.CategoryCommandContext ctx) {
        switch (ctx.category.getText()) {
            case "format":
                currentCategory = commands.getFormat();
                break;
            case "order":
                currentCategory = commands.getOrder();
                break;
            case "content":
                currentCategory = commands.getContent();
                break;
        }
    }
}
