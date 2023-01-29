package representation;

import java.util.ArrayList;
import java.util.Set;

public interface Item {
    Call getType();

    Object getValue();

    ArrayList<Object> getArguments();

    enum Call {
        action,
        flag,
        set
    }
}
