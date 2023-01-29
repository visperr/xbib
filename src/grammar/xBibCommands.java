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
        format = new Category();
        order = new Category();
        content = new Category();
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

}