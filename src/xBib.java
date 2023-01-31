import exception.ParseException;
import grammar.xBibChecker;
import grammar.xbibLexer;
import grammar.xbibParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;

public class xBib {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("No arguments");
        }
        
        String f = args[0];

        File toTest = new File(f);
        System.out.println(String.format("File %s found, parsing...", toTest.toString()));

        try {
            CharStream chars = CharStreams.fromPath(toTest.toPath());
            Lexer lexer = new xbibLexer(chars);
            xbibParser parser = new xbibParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.main();

            xBibChecker listener = new xBibChecker();
            listener.run(tree);
            System.out.println("Successfully parsed, output has been written.");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
