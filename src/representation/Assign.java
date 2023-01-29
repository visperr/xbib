package representation;

import java.util.ArrayList;
import java.util.Set;

public class Assign implements Item {
    Object value;
    ArrayList<Object> arguments;

    public Assign(String value, ArrayList<Object> arguments) {
        this.value = value;
        this.arguments = arguments;
    }

    @Override
    public Call getType() {
        return Call.set;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public ArrayList<Object> getArguments() {
        return this.arguments;
    }
}
