package exception;

import java.util.List;

public class ParseException extends Exception {

    private final List<String> messages;

    public ParseException(List<String> messages) {
        super(messages.toString());
        this.messages = messages;
    }

    /** Returns the error messages wrapped in this exception. */
    public List<String> getMessages() {
        return this.messages;
    }
}
