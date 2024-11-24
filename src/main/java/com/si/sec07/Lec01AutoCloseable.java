package com.si.sec07;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.util.CommonUtils;

/*
    ExecutorService now extends the AutoCloseable
*/
public class Lec01AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(Lec01AutoCloseable.class);

    public static void main(String[] args) {
//        var executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(Lec01AutoCloseable::task);
//        log.info("Submitted tasks");
//        executorService.shutdown(); // waiting for existing tasks to complete before shutdown
//        executorService.shutdownNow();
        try(var executorService = Executors.newSingleThreadExecutor()){
            executorService.submit(Lec01AutoCloseable::task);
            executorService.submit(Lec01AutoCloseable::task);
            executorService.submit(Lec01AutoCloseable::task);
            executorService.submit(Lec01AutoCloseable::task);
            log.info("Submitted tasks");
        }

    }

    private static void task(){
        CommonUtils.sleep(Duration.ofSeconds(1));
        log.info("Task executed");
    }
}
