package com.si.sec10;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class S0039_EndlessStreams {
    public static void main(String[] args) {
        Stream.generate(LocalDateTime::now)
                .limit(20).forEach(System.out::println);
    }
}
