package com.si.sec10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface S0007_FileDiff {
    static final Logger log = LoggerFactory.getLogger(S0007_FileDiff.class);
    static void main(String... args) throws IOException {
//        var first = Path.of("S0003_VarArgs.java");
//        var second = Path.of("S0004_Timer.java");
//        log.info(System.getProperty("user.dir"));
//        var firstDifferentByte = Files.mismatch(first, second);
//        System.out.println(firstDifferentByte);
        var log = System.getLogger("duke");
        log.log(System.Logger.Level.INFO, "Hello World!");
        System.out.println("adf");

    }
}