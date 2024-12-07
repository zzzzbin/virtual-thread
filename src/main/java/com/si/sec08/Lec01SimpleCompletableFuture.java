package com.si.sec08;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.util.CommonUtils;

/*
    A very simple demo to show how CompletableFuture works
    Intentionally NOT using factory methods
 */
public class Lec01SimpleCompletableFuture {
    private static final Logger log = LoggerFactory.getLogger(Lec01SimpleCompletableFuture.class);

    public static void main(String[] args) {
        log.info("Main Start");
        var cf = slowTask();
        cf.thenAccept(v -> log.info("value accept: {}", v));
//        log.info("Value = {}", cf.join());
        log.info("Main End");
        CommonUtils.sleep(Duration.ofSeconds(2));
    }

    private static CompletableFuture<String > fastTask(){
        log.info("Method Start");
        var cf = new CompletableFuture<String>();
        cf.complete("hello");
        log.info("Method End");
        return cf;
    }

    private static CompletableFuture<String > slowTask(){
        log.info("Method Start");
        var cf = new CompletableFuture<String>();
        Thread.ofVirtual().start(()->{
            CommonUtils.sleep(Duration.ofSeconds(1));
            cf.complete("hello ofVirtual");
        });
        log.info("Method End");
        return cf;
    }
}
