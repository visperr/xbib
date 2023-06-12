package grammar;

import representation.*;

import java.util.HashSet;
import java.util.Set;

public class xBibCommands {
    Category format;
    Category order;
    Category content;
    Set<Field> fields;

    public xBibCommands() {
        format = new Category("Format");
        order = new Category("Order");
        content = new Category("Content");
        fields = new HashSet<Field>();
    }

    public Category getFormat() {
        return format;
    }

    public Category getOrder() {
        return order;
    }

    public Category getContent() {
        return content;
    }

    public Set<Field> getFields() {
        return fields;
    }
    
    public boolean getFlagValue(Item flag) {
        return Boolean.parseBoolean(flag.getArguments().toArray()[0].toString());
    }

}