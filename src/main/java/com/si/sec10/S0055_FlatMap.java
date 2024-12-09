package com.si.sec10;

import java.util.function.Function;
import java.util.stream.Stream;

public class S0055_FlatMap {
    static Stream<String> addPrefix(String prefix){
        return Stream.of("java","duke")
                .map(s-> prefix+" "+s);
    }
    public static void main(String[] args) {

        var message = Stream.of("hey", "hi")
                .flatMap(S0055_FlatMap::addPrefix)
                .toList();
        System.out.println("message = " + message);
    }
}
