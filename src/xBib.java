import exception.ParseException;
import grammar.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class xBib {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 4) {
            System.out.println("Please provide [xbib, input, output, (possible) bbl].");
            return;
        }

        File xbib_commands = new File(args[0]);
        File input_file = new File(args[1]);
        File output_file = new File(args[2]);

        if (args.length == 4) {
            File bbl = new File(args[3]);
            run(xbib_commands, input_file, output_file, bbl);
        } else {
            run(xbib_commands, input_file, output_file);
        }
    }

    public static void run(File commands, File in, File out) {
        run(commands, in, out, null);
    }

    public static void run(File command_file, File in, File out, File bbl) {
        try {
            CharStream xbib_chars = CharStreams.fromPath(command_file.toPath());
            Lexer xbib_lexer = new xbibLexer(xbib_chars);
            xbibParser xbib_parser = new xbibParser(new CommonTokenStream(xbib_lexer));
            ParseTree tree = xbib_parser.main();
            xBibChecker xbib_listener = new xBibChecker();

            xBibCommands commands = xbib_listener.run(tree);


            CharStream bib_chars = CharStreams.fromPath((in.toPath()));
            Lexer bib_lexer = new simpleBibTeXLexer(bib_chars);
            simpleBibTeXParser bib_parser = new simpleBibTeXParser(new CommonTokenStream(bib_lexer));
            tree = bib_parser.database();

            bibTeXListener bib_listener = new bibTeXListener();

            String output_string = bib_listener.run(tree, commands);


            FileWriter fileWriter = new FileWriter(out);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(output_string);
            printWriter.close();

            System.out.println("Successfully parsed, output has been written.");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
