package com.si.sec10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class S0030_CreateTempFolderAndDirectories {
    public static void main(String[] args) throws IOException {
        var tempFolder = Files.createTempDirectory("trungnguyen");
        System.out.println("tempFolder = " + tempFolder);

        var path = Path.of("hello/duke/rocks");
        Files.createDirectories(path);

    }
}
