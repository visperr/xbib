package exception;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class ErrorListener extends BaseErrorListener {
    /** Errors collected by the listener. */
    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        this.errors.add(String.format("Line %d:%d - %s", line,
                charPositionInLine,
                msg));
    }

    /** Indicates if the listener has collected any errors. */
    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    /** Returns the (possibly empty) list of errors collected by the listener. */
    public List<String> getErrors() {
        return this.errors;
    }
    
}
