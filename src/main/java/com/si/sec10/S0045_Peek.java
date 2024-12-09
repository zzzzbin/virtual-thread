package com.si.sec10;

import java.util.List;

public class S0045_Peek {
    public static void main(String[] args) {
        var result = List.of("a", "b", "c")
                .stream()
                .filter(s -> s.startsWith("a"))
                .peek(x -> System.out.println(x))
                .map(s-> "*"+s)
                .peek(x -> System.out.println(x))
                .toList();
        System.out.println("result = " + result);
    }
}
