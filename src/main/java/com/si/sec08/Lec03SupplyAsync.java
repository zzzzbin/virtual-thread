package com.si.sec08;


import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.util.CommonUtils;

public class Lec03SupplyAsync {
    private static final Logger log = LoggerFactory.getLogger(Lec03SupplyAsync.class.getName());


    public static void main(String[] args) {
        log.info("Main Start");
        var cf = slowTask();
        cf.thenAccept(v -> log.info("value accept: {}", v));
//        log.info("Value = {}", cf.join());
        log.info("Main End");
        CommonUtils.sleep(Duration.ofSeconds(2));
    }

    private static CompletableFuture<String > slowTask(){
        log.info("Method Start");
        var cf = CompletableFuture.supplyAsync(()->{
           CommonUtils.sleep(Duration.ofSeconds(1));
           return "hihi";
        }, Executors.newVirtualThreadPerTaskExecutor());
        log.info("Method End");
        return cf;
    }
}
