package tool;

import exception.ParseException;
import grammar.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import representation.Field;
import representation.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class xBib {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 5) {
            System.out.println("Please provide [xbib, input, output, (possible) aux, [flags]].");
            return;
        }

        List<String> files = new ArrayList<>();
        writeMode flag = writeMode.NORMAL;
        for (String arg : args) {
            if (arg.startsWith("--")) {
                switch (arg) {
                    case "--normal":
                        flag = writeMode.NORMAL;
                        break;
                    case "--silent":
                        flag = writeMode.SILENT;
                        break;
                    case "--verbose":
                        flag = writeMode.VERBOSE;
                        break;
                    case "--debug":
                        flag = writeMode.DEBUG;
                        break;
                    default:
                        System.out.printf("The flag provided (%s) does not exist", arg);
                }
            } else {
                files.add(arg);
            }
        }
        
        File xbib_commands = new File(files.get(0));
        File input_file = new File(files.get(1));
        File output_file = new File(files.get(2));

        if (args.length == 4) {
            File aux = new File(args[3]);
            run(xbib_commands, input_file, output_file, aux, flag);
        } else {
            run(xbib_commands, input_file, output_file, flag);
        }
    }

    public static void run(File commands, File in, File out) {
        run(commands, in, out, null, writeMode.NORMAL);
    }

    public static void run(File commands, File in, File out, File aux) {
        run(commands, in, out, aux, writeMode.NORMAL);
    }
    public static void run(File commands, File in, File out, writeMode flag) {
        run(commands, in, out, null, flag);
    }

    public static void run(File command_file, File in, File out, File aux, writeMode writeMode) {
        try {

            switch (writeMode) {
                case VERBOSE:
                    System.out.println("Starting xBib.");
                    break;
                case DEBUG:
                    System.out.println("Starting xBib tool in DEBUG mode...");
                    break;
            }
            
            /*
            First we compile the tool.xBib file into a list of commands that can be applied
            to the BibTeX file.
             */
            CharStream xbib_chars = CharStreams.fromPath(command_file.toPath());
            Lexer xbib_lexer = new xbibLexer(xbib_chars);
            xbibParser xbib_parser = new xbibParser(new CommonTokenStream(xbib_lexer));
            ParseTree tree = xbib_parser.main();
            xBibChecker xbib_listener = new xBibChecker();

            if (writeMode == tool.writeMode.DEBUG) {
                System.out.printf("Provided xBib file: %s \n", command_file.toPath());
            }

            xBibCommands commands = xbib_listener.run(tree, writeMode);

            switch (writeMode) {
                case VERBOSE:
                    System.out.printf("Parsed file %s and compiled the code. \n", command_file.toPath());
                    break;
                case DEBUG:
                    System.out.println("Compiled the file to the following commands:");
                    System.out.printf("\t %s: \n", commands.getFormat());
                    for (Item i : commands.getFormat().getItems())
                        System.out.printf("\t \t %s\n", i);
                    System.out.printf("\t %s: \n", commands.getOrder());
                    for (Item i : commands.getOrder().getItems())
                        System.out.printf("\t \t %s\n", i);
                    System.out.printf("\t %s: \n", commands.getContent());
                    for (Item i : commands.getContent().getItems())
                        System.out.printf("\t \t %s\n", i);
                    System.out.print("\t Fields: \n");
                    for (Field f : commands.getFields())
                        System.out.printf("\t \t %s\n", f);
                    break;
            }
            
            /*
            We walk through the BibTeX file, and apply the respective commands when necessary.
             */
            CharStream bib_chars = CharStreams.fromPath((in.toPath()));
            Lexer bib_lexer = new simpleBibTeXLexer(bib_chars);
            simpleBibTeXParser bib_parser = new simpleBibTeXParser(new CommonTokenStream(bib_lexer));
            tree = bib_parser.database();
            bibTeXListener bib_listener = new bibTeXListener();

            if (writeMode == tool.writeMode.DEBUG) {
                System.out.printf("Provided BibTeX file: %s \n", in.toPath());
            }
            
            String output_string = bib_listener.run(tree, commands, writeMode);

            switch (writeMode) {
                case DEBUG:
                case VERBOSE:
                    System.out.printf("Applied the transformations to %s. \n", in.toPath());
                    break;
            }
            
            /*
            Write the resulted BibTeX string to the output location.
             */
            FileWriter fileWriter = new FileWriter(out);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(output_string);
            printWriter.close();

            switch (writeMode) {
                case DEBUG:
                case VERBOSE:
                    System.out.printf("Wrote the result to %s. \n", out.toPath());
                    break;
            }
            
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
