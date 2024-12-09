package com.si.sec10;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class S0086_StringToCSV {
    public static void main(String[] args) {
        var csv = """
        Mr. Duke
        JavaOne Avenue
        4242 Javapolis
        """.lines()
                .collect(Collectors.joining(","));
        System.out.println(csv);

        var date = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("yyyy_MM_dd"));
        System.out.println(date);

    }
}
