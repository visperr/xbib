package grammar;

import org.antlr.v4.runtime.tree.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import representation.Category;
import representation.Field;
import representation.Item;
import tool.writeMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class bibTeXListener extends simpleBibTeXBaseListener {

    StringBuilder result;
    xBibCommands commands;

    HashMap<ArrayList<String>, String> abbreviations;

    Stack<String> stack;
    LinkedHashMap<String, String> entries;

    boolean blindFlag = false;
    boolean newKeyFlag = false;


    public String run(ParseTree tree, xBibCommands commands, writeMode writeMode) {
        result = new StringBuilder();
        this.commands = commands;
        this.stack = new Stack<>();
        this.entries = new LinkedHashMap<>();

        this.abbreviations = getAbbreviations();

        new ParseTreeWalker().walk(this, tree);

        return getResult();
    }

    public String getResult() {
        return result.toString();
    }

    Item getCommand(Category cat, Item.Call type, String command) {
        for (Item i : cat.getItems()) {
            if (i.getType() == type && i.getValue().equals(command)) {
                return i;
            }
        }
        return null;
    }

    String abbreviateString(String content) {
        HashSet<String> hits = new HashSet<>();
        for (ArrayList<String> abrs : abbreviations.keySet()) {
            for (String hit : abrs) {
                if (content.contains(hit)) {
                    hits.add(abbreviations.get(abrs));
                }
            }
        }

        if (hits.size() != 0) {
            StringBuilder res = new StringBuilder();

            Object[] abrvs = hits.toArray();
            for (int i = 0; i < abrvs.length; i++) {
                res.append("{").append(abrvs[i]).append("}");

                if (i < abrvs.length - 1)
                    res.append(",");
            }

            return res.toString();
        }
        return content;
    }

    HashMap<ArrayList<String>, String> getAbbreviations() {
        HashMap<ArrayList<String>, String> res = new HashMap<>();

        try {
            InputStream in = getClass().getResourceAsStream("/data/abbreviations.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            JSONObject obj = (JSONObject) new JSONParser().parse(reader);

            JSONArray abvs = (JSONArray) obj.get("abbreviations");

            for (Object abbr : abvs) {
                String ab = ((JSONObject) abbr).get("abbr").toString();

                ArrayList<String> checks = new ArrayList<>();
                for (Object check : ((JSONArray) ((JSONObject) abbr).get("check")).toArray()) {
                    checks.add(check.toString());
                }

                res.put(checks, ab);
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return res;
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

    ArrayList<String> getFieldActions(String field) {
        ArrayList<String> actions = new ArrayList<>();

        for (Field f : commands.getFields()) {
            for (Object o : f.getNames()) {
                String n = o.toString().substring(1, o.toString().length() - 1);
                if (n.equals(field)) {
                    for (Object a : f.getActions()) actions.add(a.toString());
                }
            }
        }

        return actions;
    }

    String getIndentation() {
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


    public String getStringType() {
        Item i = getCommand(commands.getFormat(), Item.Call.set, "string_identifier");
        if (i != null) {
            return i.getArguments().toArray()[0].toString();
        }
        return "default";
    }


    @Override
    public void exitDatabase(simpleBibTeXParser.DatabaseContext ctx) {

        ArrayList<String> allEntries = new ArrayList<>(entries.values());

        //region Sorting by key
        Item i = getCommand(commands.getOrder(), Item.Call.flag, "sort");
        if (i != null && commands.getFlagValue(i)) {
            ArrayList<String> sortedKeys = new ArrayList<>(entries.keySet());
            sortedKeys.sort(Comparator.comparing(String::toLowerCase));

            for (String key : entries.keySet()) {
                allEntries.set(sortedKeys.indexOf(key), entries.get(key));
            }
        }
        //endregion

        for (String entry : allEntries)
            result.append(entry);

        //region Line wrap
        //------------------------------------------------------------------------------------------------------------
        i = getCommand(commands.getFormat(), Item.Call.set, "line_wrap");
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
                    result.insert(breakoff, String.format("\n%s", getIndentation()));
                    counter = 0;
                } else {
                    counter++;
                }
            }
        }
        //------------------------------------------------------------------------------------------------------------
        //endregion
    }

    @Override
    public void enterTagEntry(simpleBibTeXParser.TagEntryContext ctx) {
        //region Blinding
        Item j = getCommand(commands.getContent(), Item.Call.action, "blind");
        if (j != null) {
            String test = String.format("'%s'", ctx.key.getText());
            if (j.getArguments().contains(test)) {
                blindFlag = true;
            }
        }
        //endregion
    }

    @Override
    public void exitTagEntry(simpleBibTeXParser.TagEntryContext ctx) {

        String entryType = ctx.entryType.getText();
        String entryKey = ctx.key.getText();

        //region Change type
        Item[] is = getCommands(commands.getContent(), Item.Call.action, "change_type");
        for (Item i : is) {
            if (i.getArguments().size() != 2) {
                // TODO: Error
            } else {
                String from = i.getArguments().toArray()[1].toString();
                if (from.charAt(0) != '\'' && '\'' != from.charAt(from.length() - 1)) {
//                    addError(ctx, "The argument %s should be of type: Word", from);
                }
                from = String.format("@%s{", from.substring(1, from.length() - 1));
                String to = i.getArguments().toArray()[0].toString();
                if (to.charAt(0) != '\'' && '\'' != to.charAt(to.length() - 1)) {
//                    addError(ctx, "The argument %s should be of type: Word", to);
                    continue;
                }
                to = String.format("@%s{", to.substring(1, to.length() - 1));

                if (from.equals(entryType)) {
                    entryType = to;
                }
            }
        }
        //endregion

        //region Rename Key
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
        //endregion

        StringBuilder res = new StringBuilder();

        int pointer = res.length();
        while (!stack.isEmpty()) {
            String tag = stack.pop();
            res.insert(pointer, tag);
            
            if (newKeyFlag && stack.size() == 1) {
                entryKey = stack.pop();
                
                if (entries.containsKey(entryKey))
                    entryKey += 'a';
                            
                char postfix = 'b';
                while (entries.containsKey(entryKey)) {
                    entryKey = entryKey.substring(0, entryKey.length() - 1);
                    entryKey += postfix;
                    postfix++;
                }
            }
        }

        res.insert(pointer, String.format("%s %s,\n", entryType, entryKey));
        res.append("}\n");

        blindFlag = false;
        newKeyFlag = false;

        //region Filter
        boolean rem;
        Item i = getCommand(commands.getOrder(), Item.Call.action, "filter");
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
                return;
            }
        }
        //endregion

        entries.put(entryKey, res.toString());
    }

    @Override
    public void exitStringDeclaration(simpleBibTeXParser.StringDeclarationContext ctx) {
        //TODO
    }

    @Override
    public void exitPreamble(simpleBibTeXParser.PreambleContext ctx) {
        //TODO
    }

    @Override
    public void exitComment(simpleBibTeXParser.CommentContext ctx) {
        //TODO
    }

    @Override
    public void exitTags(simpleBibTeXParser.TagsContext ctx) {
        if (stack.isEmpty())
            return;

        String content = stack.pop();

        //region Last comma
        Item i = getCommand(commands.getFormat(), Item.Call.flag, "last_comma");
        if (i != null) {
            if (!commands.getFlagValue(i)) {
                // Remove last comma
                content = content.substring(0, content.length() - 2) + "\n";
            }
        }
        //endregion

        stack.push(content);
    }

    @Override
    public void exitTag(simpleBibTeXParser.TagContext ctx) {

        String content = stack.pop();

        //region Remove and abbreviate field
        for (String action : getFieldActions(ctx.Name().getText())) {
            switch (action) {
                case "remove":
                    return;
                case "abbreviate":

                    if (ctx.content().Number() != null)
                        break;

                    content = content.charAt(0) +
                            abbreviateString(content.substring(1, content.length() - 1)) +
                            content.charAt(content.length() - 1);

                    break;
            }
        }
        //endregion

        String tagName = ctx.Name().getText();

        //region Generate keys
        Item i = getCommand(commands.getContent(), Item.Call.flag, "generate_keys");
        if (i != null && commands.getFlagValue(i)) {

            if (tagName.equals("author") || tagName.equals("year")) {
                String filteredContent = content.toLowerCase().replaceAll("[{}\\\\\"/'-]", "");
                String generatedKey = "";

                if (tagName.equals("author")) {
                    String[] authors = filteredContent.split("and");
                    
                    String[] firstAuthor = authors[0].split(" ");
                    generatedKey = firstAuthor[firstAuthor.length - 1];
                    
                    if (authors.length == 2) {
                        String[] secondAuthor = authors[1].split(" ");

                        generatedKey = String.format("%s-%s",generatedKey, secondAuthor[secondAuthor.length-1]);
                    } else if (authors.length > 2) {
                        generatedKey = String.format("%s-%s", generatedKey, "etal");
                    }
                } else {
                    generatedKey = filteredContent;
                }

                if (newKeyFlag) {
                    String newKey = stack.remove(0);
                    if (tagName.equals("author")) {
                        newKey = String.format("%s-%s", generatedKey, newKey);
                    } else {
                        newKey = String.format("%s-%s", newKey, generatedKey);
                    }
                    stack.add(0, newKey);
                } else {
                    stack.add(0, generatedKey);
                    newKeyFlag = true;
                }
            }
        }
        //endregion

        String res = String.format("%s%s = %s,\n", getIndentation(), tagName, content);
        stack.push(res);
    }

    @Override
    public void exitContent(simpleBibTeXParser.ContentContext ctx) {
        if (ctx.concatable().size() != 0) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < ctx.concatable().size(); i++) {
                res.append(stack.pop());
            }

            stack.push(res.toString());
        } else if (ctx.Number() != null) {
            stack.push(ctx.Number().toString());
        } else {
            String contentString = ctx.BracedContent().toString();

            //region String type
            if (getStringType().equals("quotes")) {
                contentString = (String.format("\"%s\"", contentString.substring(1, contentString.length() - 1)));
            }
            //endregion

            stack.push(contentString);
        }

        if (blindFlag) {
            stack.pop();
            stack.push("{Anonymous}");
        }
    }

    @Override
    public void exitConcatable(simpleBibTeXParser.ConcatableContext ctx) {
        if (ctx.QuotedContent() != null) {
            //region String type
            if (getStringType().equals("braces")) {
                String newString = ctx.QuotedContent().toString();
                stack.push(String.format("{%s}", newString.substring(1, newString.length() - 1)));
            } else {
                stack.push(ctx.QuotedContent().toString());
            }
            //endregion
        } else {
            // String declaration TODO
            stack.push(ctx.Name().toString());
        }
    }
}
