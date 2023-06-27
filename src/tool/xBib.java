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

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class xBib {
    public static void main(String[] args) {
        runFiles(new File(args[0]), args[1], args[2]);
        if (args.length == 1 && args[0].equals("--help")) {
            printHelpMenu();
            return;
        }
        if (args.length < 3 || args.length > 5) {
            System.out.println("Please provide [xbib, input, output, (possible) aux, [flags]].");
            System.out.println("Type --help for more information");
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
                    case "--debug":
                        flag = writeMode.DEBUG;
                        break;
                    case "--help":
                        printHelpMenu();
                        return;
                    default:
                        System.out.printf("The flag provided (%s) does not exist, type --help for more information.", arg);
                }
            } else {
                files.add(arg);
            }
        }

        File xbib_commands = new File(files.get(0));
        File input_file = new File(files.get(1));
        File output_file = new File(files.get(2));

        try {
            if (args.length == 4) {
                File aux = new File(args[3]);
                run(xbib_commands, input_file, output_file, aux, flag);
            } else {
                run(xbib_commands, input_file, output_file, flag);
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void run(File commands, File in, File out) throws ParseException {
        run(commands, in, out, null, writeMode.NORMAL);
    }

    public static void run(File commands, File in, File out, File aux) throws ParseException {
        run(commands, in, out, aux, writeMode.NORMAL);
    }

    public static void run(File commands, File in, File out, writeMode flag) throws ParseException {
        run(commands, in, out, null, flag);
    }

    public static void run(File command_file, File in, File out, File aux, writeMode writeMode) throws ParseException {
        try {

            switch (writeMode) {
                case NORMAL:
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
                case NORMAL:
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

            Set<String> filters = new HashSet<>();
            if (aux != null) {

                BufferedReader reader = new BufferedReader(new FileReader(aux));
                String line = reader.readLine();

                switch (writeMode) {
                    case NORMAL:
                        System.out.printf("Parsed provided .AUX file %s. \n", aux.toPath());
                        break;
                    case DEBUG:
                        System.out.printf("Provided .AUX file %s. \n", aux.toPath());
                        System.out.println("Following citations found:");
                        break;
                }

                while (line != null) {
                    if (line.startsWith("\\citation{")) {
                        String key = line.substring(10).substring(0, line.length() - 11);
                        
                        if (writeMode.equals(tool.writeMode.DEBUG))
                            System.out.printf("\t%s\n", key);
                        
                        filters.add(key);
                    }

                    line = reader.readLine();
                }
            }
            
            commands.setProvidedFilter(filters);

            String output_string = bib_listener.run(tree, commands, writeMode);

            switch (writeMode) {
                case DEBUG:
                case NORMAL:
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
                case NORMAL:
                    System.out.printf("Wrote the result to %s. \n", out.toPath());
                    break;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    static void printHelpMenu() {
        System.out.println("To run the tool please provide arguments in the following format:");
        System.out.println("\t[.xbib file] [input .bib file] [output .bib location] (if necessary)[.aux file]");
        System.out.println("You can also add the following flags:");
        System.out.println("\t--normal \t default mode");
        System.out.println("\t--silent \t executes the code without any prints");
        System.out.println("\t--debug \t executes the code and prints a more detailed trace");
        System.out.println("\t--help  \t shows the help menu");
        System.out.println("For a more detailed explanation: https://github.com/visperr/xbib");
    }
    
    static void runFiles(File commands, String dirIn, String dirOut) {
        
    }
}
