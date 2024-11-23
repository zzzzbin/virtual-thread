package com.si.sec05;

/*
    Virtual Threads are indented for I/O tasks. This is a simple demo to show that race conditions are still applicable.
 */

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.si.util.CommonUtils;

/*
    Demo: Virtual Thread Pinning
 */
public class Lec05ReentrantLockWithIO {

    private static final Logger log = LoggerFactory.getLogger(Lec05ReentrantLockWithIO.class);
    private static final Lock lock = new ReentrantLock();
    private static final List<Integer> list = new ArrayList<>();
    // Use this to check if virtual threads are getting pinned in your application
    static {
        System.setProperty("jdk.tracePinnedThreads", "short");
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            log.info("==================================");
        };

        demo(Thread.ofVirtual());
        Thread.ofVirtual().start(runnable);
        CommonUtils.sleep(Duration.ofSeconds(2));

        log.info("list size: {}", list.size());
    }

    private static void demo(Thread.Builder builder){
        for (int i = 0; i < 50; i++) {
            builder.start(() -> {
                log.info("Task started. {}", Thread.currentThread());
                inIOTask();
                log.info("Task ended. {}", Thread.currentThread());
            });
        }
    }

    private static void inIOTask(){
        try {
            lock.lock();
            list.add(1);
            CommonUtils.sleep(Duration.ofSeconds(10));
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }finally {
            lock.unlock();
        }
    }

}