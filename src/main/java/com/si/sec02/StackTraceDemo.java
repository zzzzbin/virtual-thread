package com.si.sec02;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

import com.si.util.CommonUtils;

public class StackTraceDemo {
    public static void main(String[] args) {

        demo(Thread.ofVirtual().name("virtual-", 1));

        CommonUtils.sleep(Duration.ofSeconds(2));

    }

    private static void demo(Thread.Builder builder){
        for (int i = 1; i <= 20 ; i++) {
            int j = i;
            builder.start(() -> Task.execute(j));
        }
    }
}
