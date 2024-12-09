package com.si.sec10;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S0005_ScheduledThreadPool {
    private static final Logger log = LoggerFactory.getLogger(S0005_ScheduledThreadPool.class.getName());
    public static void main(String[] args) {
        var scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(()-> log.info("Hello"), 0, 1, TimeUnit.SECONDS);
    }
}
