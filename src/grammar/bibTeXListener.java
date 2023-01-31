package grammar;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import representation.Category;
import representation.Field;
import representation.Item;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class bibTeXListener extends simpleBibTeXBaseListener {

    StringBuilder result;
    xBibCommands commands;
    int entryPointer;

    Stack<String> stack;
    boolean blindFlag = false;

    public void run(ParseTree tree, xBibCommands commands) {
        result = new StringBuilder();
        this.commands = commands;
        this.stack = new Stack<>();
        new ParseTreeWalker().walk(this, tree);
    }
    public String getResult() {
        return result.toString();
    }

    TerminalNodeImpl makeNode(String newVal) {
        return new TerminalNodeImpl(new CommonToken(0, newVal));
    }

    TerminalNodeImpl makeNode(String newVal, Token token) {
        return new TerminalNodeImpl(new CommonToken(token.getType(), newVal));
    }

    Item getCommand(Category cat, Item.Call type, String command) {
        for (Item i : cat.getItems()) {
            if (i.getType() == type && i.getValue().equals(command)) {
                return i;
            }
        }
        return null;
    }

    Item[] getCommands(Category cat, Item.Call type, String command) {
        ArrayList<Item> items = new ArrayList<>();

        for (Item i : cat.getItems()) {
            if (i.getType() == type && i.getValue().equals(command)) {
                items.add(i);
            }
        }

        return items.toArray(new Item[0]);
    }

    String[] getFieldActions(String field) {
        ArrayList<String> actions = new ArrayList<>();

        for (Field f : commands.getFields()) {
            for (Object o : f.getNames()) {
                String n = o.toString().substring(1, o.toString().length() - 1);
                if (n.equals(field)) {
                    for (Object a : f.getActions()) actions.add(a.toString());
                }
            }
        }

        return actions.toArray(new String[0]);
    }

    String getIndentation(ParserRuleContext ctx) {
        StringBuilder out = new StringBuilder();
        Item i = getCommand(commands.getFormat(), Item.Call.set, "indentation");
        if (i != null) {
            int amount = 0;
            try {
                amount = Integer.parseInt(i.getArguments().toArray()[0].toString());
            } catch (NumberFormatException e) {
                return null;
            }
            switch (i.getArguments().toArray()[1].toString()) {
                case "tab":
                    for (int a = 0; a < amount; a++) {
                        out.append("\t");
                    }
                    break;
                case "space":
                    for (int a = 0; a < amount; a++) {
                        out.append(" ");
                    }
                    break;
                default:
                    break;
            }
        } else
            out.append("    ");
        return out.toString();
    }

    public char getStringChar() {
        char c = '-';
        // String identifier
        Item i = getCommand(commands.getFormat(), Item.Call.set, "string_identifier");
        if (i != null) {
            switch (i.getArguments().toArray()[0].toString()) {
                case "quotes":
                    c = '\"';
                    break;
                case "curly":
                    break;
            }
        }
        return c;
    }

    public String encapsuleString(String s) {
        switch (getStringChar()) {
            case '{':
                s = String.format("{%s}", s.substring(1, s.length() - 1));
                break;
            case '\"':
                s = String.format("\"%s\"", s.substring(1, s.length() - 1));
            case '-':
                return s;
        }
        return s;
    }

    @Override
    public void enterDatabase(simpleBibTeXParser.DatabaseContext ctx) {
        super.enterDatabase(ctx);
    }

    @Override
    public void exitDatabase(simpleBibTeXParser.DatabaseContext ctx) {


        // Line wrap
        Item i = getCommand(commands.getFormat(), Item.Call.set, "line_wrap");
        if (i != null) {
            int cap = 0;
            try {
                cap = Integer.parseInt(i.getArguments().toArray()[0].toString());
            } catch (NumberFormatException e) {
                return;
            }
            int breakoff = 0;
            int counter = 0;

            for (int c = 0; c < result.toString().length(); c++) {
                if (result.toString().charAt(c) == '\n') {
                    counter = 0;
                    continue;
                }

                if (result.toString().charAt(c) == ' ') breakoff = c + 1;

                if (counter > cap) {
                    // Char limit reached
                    result.insert(breakoff, String.format("\n%s", getIndentation(ctx)));
                    counter = 0;
                } else {
                    counter++;
                }
            }
        }
    }

    @Override
    public void enterEntry(simpleBibTeXParser.EntryContext ctx) {
        entryPointer = result.length();

        String entryType = ctx.entryType.getText();
        String entryKey = ctx.key.getText();

        // Blinding
        Item j = getCommand(commands.getContent(), Item.Call.action, "blind");
        if (j != null) {
            String test = String.format("'%s'", ctx.key.getText());
            if (j.getArguments().contains(test)) {
                blindFlag = true;
            }
        }

        // Change type
        Item[] is = getCommands(commands.getContent(), Item.Call.action, "change_type");
        for (Item i : is) {
            if (i.getArguments().size() != 2) {
                // TODO: Error
            } else {
                String from = i.getArguments().toArray()[1].toString();
                if (from.charAt(0) != '\'' && '\'' != from.charAt(from.length() - 1)) {
//                    addError(ctx, "The argument %s should be of type: Word", from);
                }
                from = from.substring(1, from.length() - 1);
                String to = i.getArguments().toArray()[0].toString();
                if (to.charAt(0) != '\'' && '\'' != to.charAt(to.length() - 1)) {
//                    addError(ctx, "The argument %s should be of type: Word", to);
                    continue;
                }
                to = to.substring(1, to.length() - 1);

                if (from.equals(entryType)) {
                    entryType = to;
                }
            }
        }

        // Rename key
        is = getCommands(commands.getContent(), Item.Call.action, "rename_key");
        for (Item i : is) {
            if (i.getArguments().size() != 2) {
                // TODO: Error
            } else {
                String from = i.getArguments().toArray()[1].toString();
                if (from.charAt(0) != '\'' && '\'' != from.charAt(from.length() - 1)) {
//                    addError(ctx, "The argument %s should be of type: Word", from);
                }
                from = from.substring(1, from.length() - 1);
                String to = i.getArguments().toArray()[0].toString();
                if (to.charAt(0) != '\'' && '\'' != to.charAt(to.length() - 1)) {
//                    addError(ctx, "The argument %s should be of type: Word", to);
                    continue;
                }
                to = to.substring(1, to.length() - 1);

                if (from.equals(entryKey)) {
                    entryKey = to;
                }
            }
        }

        result.append(String.format("@%s{ %s,\n", entryType, entryKey));
    }

    @Override
    public void exitEntry(simpleBibTeXParser.EntryContext ctx) {

        // Last comma
        Item i = getCommand(commands.getFormat(), Item.Call.flag, "last_comma");
        if (i != null) {
            if (!Boolean.parseBoolean(i.getArguments().toArray()[0].toString())) {
                // Remove last comma
                result.deleteCharAt(result.length() - 2);
            }
        }

        blindFlag = false;
        result.append("}\n");

        // Filter
        boolean rem = false;
        i = getCommand(commands.getOrder(), Item.Call.action, "filter");
        if (i != null) {
            rem = true;
            for (Object k : i.getArguments()) {
                if (k.toString().charAt(0) != '\'' && '\'' != k.toString().charAt(k.toString().length() - 1)) {
//                    addError(ctx, "The argument %s should be of type: Word", k.toString());
                    continue;
                }
                String key = k.toString().substring(1, k.toString().length() - 1);
                if (ctx.key.getText().equals(key)) {
                    rem = false;
                }
            }

            if (rem) {
                // Remove the entry
                result.replace(entryPointer, result.length(), "");
            }
        }
        
        // Smart Filter
        i = getCommand(commands.getOrder(), Item.Call.action, "smart_filter");
        if (i != null) {
            
        }
    }

    @Override
    public void enterData(simpleBibTeXParser.DataContext ctx) {
        String s = String.format("%s%s = ", getIndentation(ctx), ctx.field.getText());
        stack.push(s);
    }

    @Override
    public void exitData(simpleBibTeXParser.DataContext ctx) {

        // Blinding
        Item i = getCommand(commands.getContent(), Item.Call.action, "blind");
        if (i != null && blindFlag) {
            stack.pop();
            stack.push(encapsuleString("{Anonymous}"));
        }

        // Field actions
        for (String action : getFieldActions(ctx.field.getText())) {
            switch (action) {
                case "remove":
                    stack.empty();
                    return;
                case "abbreviate":
                    try {
                        JSONObject obj = (JSONObject) new JSONParser().parse(new FileReader("src/data/abbreviations.json"));

                        JSONArray abvs = (JSONArray) obj.get("abbreviations");

                        Stack<String> newAbvs = new Stack<>();
                        for (Object possible : abvs) {
                            JSONArray check = (JSONArray) ((JSONObject) possible).get("check");
                            String name = stack.peek();
                            for (Object regx : check) {
                                if (name.contains(regx.toString())) {
                                    newAbvs.push(((JSONObject) possible).get("abbr").toString());
                                    break;
                                }
                            }
                        }

                        if (!newAbvs.isEmpty()) {
                            StringBuilder name = new StringBuilder();
                            name.append(stack.peek().charAt(0));
                            name.append("{");
                            name.append(newAbvs.pop());

                            while (!newAbvs.isEmpty()) {
                                name.append(String.format("/%s", newAbvs.pop()));
                            }
                            name.append("}");
                            name.append(stack.peek().charAt(stack.pop().length() - 1));

                            stack.push(name.toString());
                        }

                    } catch (IOException | ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }

        String val = stack.pop();
        String before = stack.pop();
        stack.empty();

        result.append(String.format("%s%s,\n", before, val));
    }

    @Override
    public void exitIntegerValue(simpleBibTeXParser.IntegerValueContext ctx) {
        stack.push(ctx.Integer().getText());
    }

    @Override
    public void exitIdValue(simpleBibTeXParser.IdValueContext ctx) {
        stack.push(ctx.Identifier().getText());
    }

    @Override
    public void exitStringValue(simpleBibTeXParser.StringValueContext ctx) {

        String s = ctx.String().toString();

        stack.push(encapsuleString(s));
    }
}
