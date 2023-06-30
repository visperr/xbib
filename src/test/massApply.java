package test;

import exception.ParseException;
import tool.writeMode;
import tool.xBib;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class massApply {
    public static void main(String[] args) {
        File dir = new File("src/test/mass");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.toString().endsWith(".bib")) {
                    try {
                        xBib.run(new File("src/test/mass/commands.xbib"), child, new File("src/test/mass/out/" + child.getName()), writeMode.SILENT);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
