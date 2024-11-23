package com.si.sec01;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {
    public static final Logger log = LoggerFactory.getLogger(Task.class);
    public static void ioIntensive(int i){
        try {
            log.info("Starting I/O task{}", i);
            Thread.sleep(Duration.ofSeconds(10));
            log.info("Ending I/O task{}", i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
