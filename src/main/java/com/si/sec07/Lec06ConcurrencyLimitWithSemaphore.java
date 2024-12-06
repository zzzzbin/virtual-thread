package com.si.sec07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.sec07.concurrencylimit.ConcurrencyLimiter;
import com.si.sec07.externalservice.Client;

public class Lec06ConcurrencyLimitWithSemaphore {
    private static final Logger log = LoggerFactory.getLogger(Lec06ConcurrencyLimitWithSemaphore.class);

    public static void main(String[] args) throws Exception {
        var limiter = new ConcurrencyLimiter(Executors.newVirtualThreadPerTaskExecutor(), 3);
        execute(limiter,20);
    }

    //3rd party service
    // contract: 3 concurrent calls are allowed
    private static String printProductInfo(int id){
        var product = Client.getProduct(id);
        log.info("{} => {}", id, product);
        return product;
    }

    private static void execute(ConcurrencyLimiter concurrencyLimiter, int taskCount) throws Exception {
        try(concurrencyLimiter){
            for (int i = 1; i < taskCount; i++) {
                int finalI = i;
                concurrencyLimiter.submit(()-> printProductInfo(finalI));
            }
            log.info("Finished executing tasks");
        }
    }
}
