package com.si.sec08.externalservice;

public class Test {
    public static void main(String[] args) {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Executing: " + name);
        };
        Thread thread = new Thread(task);
        thread.start();
        Thread thread2 = new Thread(task);
        thread2.start();
    }
}
