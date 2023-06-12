package representation;

import java.util.ArrayList;
import java.util.Set;

public class Action implements Item {
    Object value;
    ArrayList<Object> arguments;

    public Action(String function, ArrayList<Object> arguments) {
        this.value = function;
        this.arguments = arguments;
    }

    @Override
    public Call getType() {
        return Call.action;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public ArrayList<Object> getArguments() {
        return this.arguments;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s",getValue(), getArguments());
    }
}
