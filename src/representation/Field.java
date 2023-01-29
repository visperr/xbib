package representation;

import java.util.ArrayList;
import java.util.Set;

public class Field {
    ArrayList<Object> names;

    ArrayList<Object> actions;
    public Field(ArrayList<Object> names, ArrayList<Object> actions) {
        this.actions = actions;
        this.names = names;
    }

    public ArrayList<Object> getNames() {
        return names;
    }

    public ArrayList<Object> getActions() {
        return actions;
    }
}
