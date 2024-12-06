package com.si.sec07.concurrencylimit;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrencyLimiterOrder implements AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(ConcurrencyLimiterOrder.class);

    private final ExecutorService executor;
    private final Semaphore semaphore;
    private final Queue<Callable<?>> queue;

    public ConcurrencyLimiterOrder(ExecutorService executor, int limit) {
        this.executor = executor;
        this.semaphore = new Semaphore(limit);
        this.queue = new ConcurrentLinkedQueue<>();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        queue.add(callable);
       return executor.submit(()-> executeTask());
    }

    private <T> T executeTask() {
        try{
            semaphore.acquire();
           return (T)this.queue.poll().call();
        }catch (Exception e) {
            log.error("Exception occurred while trying to acquire semaphore", e);
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        this.executor.close();
    }
}
