package grammar;

import com.sun.tools.javac.Main;
import exception.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import representation.*;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;

import static java.lang.Integer.parseInt;


public class xBibChecker extends xbibBaseListener {

    xBibCommands commands;
    Stack<Object> mem;
    Stack<Item> items;

    private List<String> errors;

    public void run(ParseTree tree) throws ParseException {
        this.errors = new ArrayList<>();
        new ParseTreeWalker().walk(this, tree);
        if (hasErrors()) {
            throw new ParseException(getErrors());
        }
    }

    boolean hasErrors() {
        return !getErrors().isEmpty();
    }

    public List<String> getErrors() {
        return this.errors;
    }

    void addError(Token token, String message, Object... args) {
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }

    private void addError(ParserRuleContext node, String message,
                          Object... args) {
        addError(node.getStart(), message, args);
    }

    String getFileContents(String path) {
        Path read = getPath(path);
        try {
            return Files.readString(read);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Path getPath(String path) {
        String str = path.substring(1, path.length() - 1);
        return Path.of(str);
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
    public void exitMain(xbibParser.MainContext ctx) {
        // Import file from the path given
        String in = getFileContents(ctx.in.getText());

        // Do stuff
        CharStream chars = CharStreams.fromString(in);
        Lexer lexer = new simpleBibTeXLexer(chars);
        simpleBibTeXParser parser = new simpleBibTeXParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.database();

        bibTeXListener listener = new bibTeXListener();

        listener.run(tree, commands);

        String res = listener.getResult();

        Path out = getPath(ctx.out.getText());

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(out.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(res);
        printWriter.close();
    }

    @Override
    public void exitFieldCommand(xbibParser.FieldCommandContext ctx) {
        ArrayList<Object> arguments = new ArrayList<>();
        ArrayList<Object> actions = new ArrayList<>();

        if (ctx.argument(0).getChildCount() == 0 || ctx.argument(1).getChildCount() == 0) {
            addError(ctx, "Field should have 2 arguments.");
            return;
        }
        for (int x = 0; x < countTerminalArguments(ctx.argument(1)); x++) {
            String[] allowed = {"remove", "abbreviate"};
            if (Arrays.asList(allowed).contains(mem.peek().toString())) {
                actions.add(mem.pop());
            } else {
                addError(ctx, "Action %s is currently not supported.", mem.peek().toString());
                mem.pop();
            }
        }
        for (int x = 0; x < countTerminalArguments(ctx.argument(0)); x++) {
            String arg = mem.pop().toString();
            if (arg.charAt(0) != '\'' && '\'' != arg.charAt(arg.length() - 1)) {
                addError(ctx, "The argument %s should be of type: Word", arg);
                continue;
            }
            arguments.add(arg);
        }
        if (!mem.isEmpty()) {
            addError(ctx, "Field should have 2 arguments, %d arguments found", ctx.argument().size());
            System.out.println("error");
        }

        commands.getFields().add(new Field(arguments, actions));
    }

    @Override
    public void enterMessageCommand(xbibParser.MessageCommandContext ctx) {
        super.enterMessageCommand(ctx);
    }

    @Override
    public void exitMessageCommand(xbibParser.MessageCommandContext ctx) {
        super.exitMessageCommand(ctx);
    }


    void validateCategory(Category cat, JSONArray funs, ParserRuleContext ctx) {
        // Loop through each item in the category
        while (!items.isEmpty()) {
            Item prev = items.peek();
            for (Object f : funs) {
                if (items.isEmpty())
                    return;

                JSONObject fun = (JSONObject) f;

                // Find the corresponding values
                if (fun.get("function").toString().equals(items.peek().getValue().toString())) {
                    Item item = items.pop();
                    if (!item.getType().toString().equals(fun.get("type").toString())) {
                        addError(ctx, "The function %s is of type %s, not the provided type: %s", fun.get("function"), fun.get("type"), item.getType().toString());
                        break;
                    }
                    JSONArray arguments = (JSONArray) fun.get("arguments");
                    switch (fun.get("type").toString()) {
                        case "flag":
                            if (item.getArguments().size() != 1) {
                                addError(ctx, "A flag can only be enabled or disabled");
                                break;
                            }
                            if (!(item.getArguments().get(0).toString().equals("true") || item.getArguments().get(0).toString().equals("false"))) {
                                addError(ctx, "A flag can only be enabled or disabled, not %s", item.getArguments().get(0));
                                break;
                            }
                            cat.addItem(item);
                            break;
                        case "set":
                            if (arguments.size() != item.getArguments().size()) {
                                addError(ctx, "%d arguments are required, %d provided", arguments.size(), item.getArguments().size());
                                break;
                            }
                            for (int i = 0; i < arguments.size(); i++) {
                                Object arg = arguments.get(i);

                                if (arg.getClass().equals(String.class)) {
                                    switch (arg.toString()) {
                                        case "Integer":
                                            try {
                                                Integer.parseInt((String) item.getArguments().get(i));
                                            } catch (NumberFormatException e) {
                                                addError(ctx, "Argument %s should be of type Integer", item.getArguments().get(i).toString());
                                                break;
                                            }
                                            cat.addItem(item);
                                            break;
                                        case "Word":
                                            String w = item.getArguments().get(i).toString();
                                            if (!(w.charAt(0) == '\'' && w.charAt(w.length() - 1) == '\'')) {
                                                addError(ctx, "Argument %s should be of type Word", w);
                                                break;
                                            }
                                            cat.addItem(item);
                                            break;
                                    }
                                } else if (arg.getClass().equals(JSONArray.class)) {
                                    JSONArray allowed = (JSONArray) arg;
                                    if (!allowed.contains(item.getArguments().get(arguments.size() - i - 1).toString())) {
                                        addError(ctx, "%s can only be of type: %s", item.getArguments().get(arguments.size() - i - 1).toString(), allowed);
                                        break;
                                    }
                                    cat.addItem(item);
                                }
                                break;
                            }
                            break;
                        case "action":
                            cat.addItem(item);
                            break;
                    }
                }
            }
            
            if (!items.isEmpty() && prev == items.peek()) {
                addError(ctx, "The function %s does not exist in the category %s", items.peek().getValue().toString(), cat.toString());
                items.pop();
            }
        }
    }

    @Override
    public void exitCategoryCommand(xbibParser.CategoryCommandContext ctx) {

        // Parsing the JSON file with all the function data
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            InputStream in = getClass().getResourceAsStream("/data/allowed.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            
            Object ob = new JSONParser().parse(reader);
            JSONObject obj = (JSONObject) ob;

            switch (ctx.category.getText()) {
                case "format":

                    JSONArray funs = (JSONArray) obj.get("format");

                    validateCategory(commands.getFormat(), funs, ctx);
                    break;
                case "order":

                    funs = (JSONArray) obj.get("order");

                    validateCategory(commands.getOrder(), funs, ctx);
                    break;
                case "content":
                    
                    funs = (JSONArray) obj.get("content");

                    validateCategory(commands.getContent(), funs, ctx);
                    break;
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        } 
    }

    @Override
    public void exitSetItem(xbibParser.SetItemContext ctx) {
        ArrayList<Object> arguments = new ArrayList<>();
        while (!mem.isEmpty()) {
            arguments.add(mem.pop());
        }

        items.push(new Assign(ctx.value.getText(), arguments));
    }

    @Override
    public void exitActionItem(xbibParser.ActionItemContext ctx) {
        ArrayList<Object> arguments = new ArrayList<>();
        while (!mem.isEmpty()) {
            arguments.add(mem.pop());
        }
        items.push(new Action(ctx.function.getText(), arguments));
    }

    @Override
    public void exitFlagItem(xbibParser.FlagItemContext ctx) {
        if (ctx.flag == null) {
            return;
        }
        Boolean val = ctx.call.getText().equals("enable");
        items.push(new Flag(ctx.flag.getText(), val));
    }

    @Override
    public void exitPrimitive(xbibParser.PrimitiveContext ctx) {
        mem.push(ctx.getText());
    }
}
