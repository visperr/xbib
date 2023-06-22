package grammar;

import representation.*;

import java.util.HashSet;
import java.util.Set;

public class xBibCommands {
    Category format;
    Category order;
    Category content;
    Set<Field> fields;
    Set<String> providedFilter;

    public xBibCommands() {
        format = new Category("format");
        order = new Category("order");
        content = new Category("content");
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
    
    public Set<String> getProvidedFilter() {return providedFilter;}
    
    public void setProvidedFilter(Set<String> filter) { this.providedFilter = filter;}
}