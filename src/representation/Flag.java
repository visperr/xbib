package representation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Flag implements Item {
    Object value;

    Boolean enable;

    public Flag(String flag, Boolean enable) {
        this.value = flag;
        this.enable=enable;
    }

    @Override
    public Call getType() {
        return Call.flag;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public ArrayList<Object> getArguments() {
        ArrayList<Object> set = new ArrayList<>();
        set.add(this.enable);
        return set;
    }
}
