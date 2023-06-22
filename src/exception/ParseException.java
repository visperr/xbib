package exception;

import java.util.List;

public class ParseException extends Exception {
    
    public ParseException(String messages) {
        super(messages.toString());
    }
}
