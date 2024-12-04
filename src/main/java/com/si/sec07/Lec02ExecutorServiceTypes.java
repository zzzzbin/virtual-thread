package com.si.sec07;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.util.CommonUtils;

/**
 *     To discuss various executor service types
 */
public class Lec02ExecutorServiceTypes {
    private static final Logger log = LoggerFactory.getLogger(Lec02ExecutorServiceTypes.class);

    public static void main(String[] args) {
//        execute(Executors.newSingleThreadExecutor(), 3);
//        execute(Executors.newFixedThreadPool(5), 20);
//        execute(Executors.newCachedThreadPool(),200);
//        execute(Executors.newVirtualThreadPerTaskExecutor(),10_000);
        scheduled();

    }

    private static void scheduled(){
        try(var executor = Executors.newSingleThreadScheduledExecutor()){
            executor.scheduleAtFixedRate(()-> {
                log.info("Executing task");
            },0,1, TimeUnit.SECONDS);
            CommonUtils.sleep(Duration.ofSeconds(10));
        }
    }

    private static void execute(ExecutorService executorService, int taskCount) {
        try(executorService){
            for (int i = 0; i < taskCount; i++) {
                int finalI = i;
                executorService.submit(()-> ioTask(finalI));
            }
            log.info("Finished executing tasks");
        }
    }
    private static void ioTask(int i) {
        log.info("Task started: {}. Thread info {}", i, Thread.currentThread());
        CommonUtils.sleep(Duration.ofSeconds(5));
        log.info("Task ended: {}. Thread info {}", i, Thread.currentThread());

    }
}
