package com.si.sec10;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class S0056_MapMulti {
    // 1 -> n
    static void expand(String csv,
                       Consumer<String> sink) {
        for (var e : csv.split(","))
            sink.accept(e);
    }

    static void main(String... args) throws InterruptedException, ExecutionException {
        var csv = Stream
                .of("hello,world",
                        "duke,java");
        var expanded = csv
                .mapMulti(S0056_MapMulti::expand)
                .toList();
        System.out.println(expanded);

        var future = Executors
                .newCachedThreadPool()
                .submit(S0056_MapMulti::slowMessage);

        System.out.println(future.state());
        TimeUnit.SECONDS.sleep(1);
        System.out.println(future.state());
        System.out.println(future.get());
    }
    static String slowMessage() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
        }
        return "dukeGPT";
    }
}
