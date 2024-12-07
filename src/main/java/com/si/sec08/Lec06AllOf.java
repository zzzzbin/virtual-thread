package com.si.sec08;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.sec08.aggregator.AggregatorService;

public class Lec06AllOf {
    private static final Logger log = LoggerFactory.getLogger(Lec06AllOf.class.getName());
    public static void main(String[] args) {
        // beans / singletons
        var executor = Executors.newVirtualThreadPerTaskExecutor();
        var aggregator = new AggregatorService(executor);

        // create futures
        var futures = IntStream.rangeClosed(52, 100)
                .mapToObj(id -> CompletableFuture.supplyAsync(() -> aggregator.getProductDto(id), executor))
                .toList();

        // wait for all the completable-futures to complete
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        var list = futures.stream()
                .map(CompletableFuture::join)
                .toList();

        log.info("list: {}", list);
    }
}
