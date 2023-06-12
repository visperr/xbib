package test;

import org.junit.jupiter.api.Test;
import tool.writeMode;
import tool.xBib;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class xBibTest {

    @Test
    public void TestAbbreviate() {
        testFolder("src/test/abbreviate", "src/test/abbreviate/custom.bib");
    }
    
    @Test
    public void TestLastComma() {
        testFolder("src/test/last_comma", "src/test/input_bib.bib");
    }

    @Test
    public void TestLineWrap() {
        testFolder("src/test/line_wrap", "src/test/input_bib.bib");
    }

    @Test
    public void TestStringType() {
        testFolder("src/test/string_type", "src/test/input_bib.bib");
    }

    @Test
    public void TestRemoveField() {
        testFolder("src/test/remove_field", "src/test/input_bib.bib");
    }

    @Test
    public void TestFilter() {
        testFolder("src/test/filter", "src/test/input_bib.bib");
    }

    @Test
    public void TestRenameKey() {
        testFolder("src/test/rename_key", "src/test/input_bib.bib");
    }

    @Test
    public void TestChangeType() {
        testFolder("src/test/change_type", "src/test/input_bib.bib");
    }

    @Test
    public void TestBlinding() {
        testFolder("src/test/blind", "src/test/input_bib.bib");
    }

    @Test
    public void TestIndentation() {
        testFolder("src/test/indentation", "src/test/input_bib.bib");
    }

    void testFolder(String folder, String input) {
        File dir = new File(folder);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {

            ArrayList<File> toTest = new ArrayList<>();
            ArrayList<File> expected = new ArrayList<>();

            for (File child : directoryListing) {
                if (child.toString().endsWith(".xbib")) {
                    toTest.add(child);
                } else if (child.toString().endsWith((".bib"))) {
                    expected.add(child);
                }
            }

            try {
                for (int i = 0; i < toTest.size(); i++) {
                    xBib.run(toTest.get(i), new File(input), new File("out.bib"), writeMode.DEBUG);
                    assertTrue(compareFiles(new File("out.bib"), expected.get(i)));
                }
                new File(("out.bib")).delete();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean compareFiles(File file1, File file2) throws IOException {
        try (BufferedReader bf1 = Files.newBufferedReader(file1.toPath());
             BufferedReader bf2 = Files.newBufferedReader(file2.toPath())) {

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
