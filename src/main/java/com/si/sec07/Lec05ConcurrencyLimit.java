package com.si.sec07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.sec07.externalservice.Client;

public class Lec05ConcurrencyLimit {
    private static final Logger log = LoggerFactory.getLogger(Lec05ConcurrencyLimit.class);

    public static void main(String[] args) {
        var factory = Thread.ofVirtual().name("vins", 1).factory();
        execute(Executors.newFixedThreadPool(3, factory), 20);
    }

    //3rd party service
    // contract: 3 concurrent calls are allowed
    private static void printProductInfo(int id){
        log.info("{} => {}", id, Client.getProduct(id));
    }

    private static void execute(ExecutorService executorService, int taskCount) {
        try(executorService){
            for (int i = 1; i < taskCount; i++) {
                int finalI = i;
                executorService.submit(()-> printProductInfo(finalI));
            }
            log.info("Finished executing tasks");
        }
    }
}
