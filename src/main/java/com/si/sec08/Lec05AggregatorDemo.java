package com.si.sec08;



import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.sec08.aggregator.AggregatorService;


public class Lec05AggregatorDemo {
    private static final Logger log = LoggerFactory.getLogger(Lec05AggregatorDemo.class.getName());
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // beans / singletons
        var executor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().name("vins").factory());
        var aggregator = new AggregatorService(executor);
        log.info("product = {}", aggregator.getProductDto(50));
    }
}
