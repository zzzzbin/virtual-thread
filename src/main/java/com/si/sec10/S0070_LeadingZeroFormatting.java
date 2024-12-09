package com.si.sec10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class S0070_LeadingZeroFormatting {
    static void main(String... args) {
        IntStream.rangeClosed(0, 10)
                .mapToObj("%03d"::formatted)
                .forEach(out::println);

        var dir = Path.of(".");
        try(var files = Files.list(dir)
                .map(Path::toString)
                .filter(f -> f.endsWith(".txt"))
                .sorted()){
            System.out.println(files.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
