package test;
import exception.ErrorListener;
import exception.ParseException;
import grammar.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class xBibTest {

    @Test
    public void testAll() throws ParseException {
        testFolder("src/test/bigtest");
    }

    @Test
    public void testImport() throws ParseException {
        testFolder("src/test/import");
    }

    @Test
    public void testLastComma() throws ParseException {
        testFolder("src/test/lastcomma_disable");
        testFolder("src/test/lastcomma_enable");
    }

    @Test
    public void testIndentation() throws ParseException {
        testFolder("src/test/indentation_tab");
        testFolder("src/test/indentation_space");
        testFolder("src/test/indentation_default");
    }

    @Test
    public void testString() throws ParseException {
        testFolder("src/test/string_quote");
        testFolder("src/test/string_curly");
    }

    @Test
    public void testLineWrap() throws ParseException {
        testFolder("src/test/line_wrap_off");
        testFolder("src/test/line_wrap_on");
    }
    
    @Test
    public void testFilter() throws ParseException {
        testFolder("src/test/filter");
    }
    
    @Test
    public void testChangeType() throws ParseException {
        testFolder("src/test/change_type");
    }
    
    @Test
    public void testRenameKey() throws ParseException {
        testFolder("src/test/rename_key");
    }
    
    @Test
    public void testField() throws ParseException {
        testFolder("src/test/remove_field");
    }
    
    @Test
    public void testBlind() throws ParseException {
        testFolder("src/test/blind");
    }
    
    @Test
    public void testAbbreviate() throws ParseException {
        testFolder("src/test/abbreviate");
    }
    
//    @Test
    public void TestSmartFilter() throws ParseException {
        testFolder("src/test/smart_filter");
    }

    //@Test
    public void testExceptions() throws ParseException {
        String[] exs ={"line 6:11 - mismatched input '10' expecting Identifier", "line 7:11 - mismatched input ''asd'' expecting Identifier"
                , "line 8:4 - mismatched input 'enabl' expecting {'set', 'action', Activate}" , "line 9:0 - mismatched input ')' expecting {'set', 'action', Activate}"
                , "line 13:1 - mismatched input ';' expecting {',', ')'}", "line 18:4 - extraneous input 'action' expecting {',', ')'}"
                , "line 18:32 - mismatched input ''article'' expecting {'set', 'action', Activate}", "line 19:0 - mismatched input ')' expecting ';'"
                , "line 24:0 - missing ';' at 'output'"};
        testParseException("src/test/grammar_exception", List.of(exs));

        exs = new String[]{"Line 3:0 - Function blabla is currently not supported.", "Line 7:0 - Function fun is currently not supported.",
                "Line 11:0 - Function test is currently not supported.", "Line 15:0 - Action test2 is currently not supported.",
                "Line 17:0 - Field should have 2 arguments."};
        testParseException("src/test/missing_exception", List.of(exs));

        testRunException("src/test/type_exception", List.of(new String[]{"test"}), List.of(new String[]{"Line 23:0 - The argument address should be of type: Word"}));
    }

    void testParseException(String path, List<String> exs) {
        try {
            testFolder(path);
            fail();
        } catch (ParseException e) {
            if (!e.getMessages().equals(exs)) {
                System.out.println(e.getMessages());
                fail();
            }
        }
    }
    void testParseException(String path, String ex) {
        testParseException(path, Arrays.asList(ex));
    }

    void testRunException(String path, List<String> exs, List<String> parsexs) throws ParseException {
        try {
            testFolder(path);
        } catch (ParseException e) {
            if (parsexs == null)
                throw e;
            if (!e.getMessages().equals(parsexs)) {
                System.out.println(e.getMessages());
                fail();
            }
        }
    }

    public void testFolder(String folder) throws ParseException {
        try {
            File toTest = new File(folder + "/commands.xbib");

            ErrorListener listener = new ErrorListener();
            CharStream chars = CharStreams.fromPath(toTest.toPath());
            Lexer lexer = new xbibLexer(chars);
            lexer.removeErrorListeners();
            lexer.addErrorListener(listener);
            xbibParser parser = new xbibParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(listener);
            ParseTree tree = parser.main();

            xBibChecker checker = new xBibChecker();
            checker.run(tree);

            listener.throwException();

            File out = new File(folder + "/out.bib");
            File expected = new File(folder + "/expected.bib");

            assertTrue(compareFiles(out.toPath(), expected.toPath()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean compareFiles(Path path1, Path path2) throws IOException {
        try (BufferedReader bf1 = Files.newBufferedReader(path1);
             BufferedReader bf2 = Files.newBufferedReader(path2)) {

            String line1 = "", line2 = "";
            while ((line1 = bf1.readLine()) != null) {
                line2 = bf2.readLine();
                if (!line1.equals(line2)) {
                    System.out.println(line1 + "// \n " + line2);
                    return false;
                }
            }
            return bf2.readLine() == null;
        }
    }
}
