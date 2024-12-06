package com.si.sec07.aggregator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import com.si.sec07.externalservice.Client;

public class AggregatorService {
    private final ExecutorService executorService;

    public AggregatorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public ProductDto getProductDto(int id) throws ExecutionException, InterruptedException {
        var product = executorService.submit(() -> Client.getProduct(id));
        var rating = executorService.submit(() -> Client.getRating(id));
        return new ProductDto(id, product.get(), rating.get());
    }
}
