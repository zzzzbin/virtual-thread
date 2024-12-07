package com.si.sec08.aggregator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.si.sec07.externalservice.Client;

public class AggregatorService {
    private final ExecutorService executorService;

    public AggregatorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public ProductDto getProductDto(int id) throws ExecutionException, InterruptedException {
        var product = CompletableFuture.supplyAsync(() -> Client.getProduct(id), executorService)
                .orTimeout(250, TimeUnit.MILLISECONDS)
                .exceptionally(ex -> "Product not found");
        var rating = CompletableFuture.supplyAsync(() -> Client.getRating(id), executorService)
                .exceptionally(ex -> -1)
                .orTimeout(250, TimeUnit.MICROSECONDS)
                .exceptionally(ex -> -2);
        return new ProductDto(id, product.get(), rating.get());
    }
}
