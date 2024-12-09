package com.si.sec10;

import java.util.List;

public class S0093_FlattenNestedList {
    public static void main(String[] args) {
        var nestedList = List.of(
                List.of(1,2),
                List.of(3,4),
                List.of(5,6)
        );
        var flatLis =nestedList
                .stream()
                .flatMap(List::stream)
                .toList();
        System.out.println("flatLis = " + flatLis);
    }
}
