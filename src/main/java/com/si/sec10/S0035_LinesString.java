package com.si.sec10;

import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Path.*;



public class S0035_LinesString {
    public static void main(String[] args) throws IOException {
        var result = """
                duke is nice
                java rocks
                james likes duke
                """.lines().filter(l -> l.contains("java"))
                        .findAny()
                                .orElse("not found");
        System.out.println( result);
        Files.copy(of("./src/main/java/com/si/sec10/S0035_LinesString.java"), of("./src/main/java/com/si/sec10/S0035_LinesString.next"));

    }
}
