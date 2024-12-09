package com.si.sec10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class S0100_CountdownLatchLoop {
    static boolean even() {
        return System.nanoTime() % 2 == 0;
    }

    static void main(String... args) throws InterruptedException {
        var latch = new CountDownLatch(5);
        do{
            if(even()){
                System.out.println("even");
            }else{
                latch.countDown();
                System.out.println(latch.getCount());
            }
        }while(latch.await(100, TimeUnit.MILLISECONDS));

    }
}
