package com.si.sec08;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.util.CommonUtils;

/**
 * Factory method
 * Run async
 * Executor
 */
public class Lec02RunAsync {
    private static final Logger log = LoggerFactory.getLogger(Lec02RunAsync.class.getName());
    public static void main(String[] args) {
        log.info("Start Lec02RunAsync");
        runAsync()
                .thenRun(() -> log.info("Finished Lec02RunAsync"))
                        .exceptionally(throwable -> {
                           log.error("Exception in Lec02RunAsync", throwable);
                           return null;
                        });
        log.info("End Lec02RunAsync");
        CommonUtils.sleep(Duration.ofSeconds(2));
    }

    private static CompletableFuture<Void> runAsync (){
        log.info("Method Start");
        var cf = CompletableFuture.runAsync(()->{
            CommonUtils.sleep(Duration.ofSeconds(1));
            throw new RuntimeException("oops");
//            log.info("Task completed");
        }, Executors.newVirtualThreadPerTaskExecutor());
        log.info("Method End");
        return cf;
    }
}
