package exception;

import java.util.List;

public class RunException extends Exception{
    private final List<String> messages;

    public RunException(List<String> messages) {
        super(messages.toString());
        this.messages = messages;
    }

    /** Returns the error messages wrapped in this exception. */
    public List<String> getMessages() {
        return this.messages;
    }
}
