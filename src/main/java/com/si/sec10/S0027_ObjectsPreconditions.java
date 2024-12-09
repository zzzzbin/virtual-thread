package com.si.sec10;

import java.time.LocalDateTime;
import java.util.Objects;

public class S0027_ObjectsPreconditions {
    public static void main(String[] args) {
        parameterPlease(null);
    }
    static String error(){
        return "input please now: " + LocalDateTime.now();
    }
    private static void parameterPlease(String input) {
        Objects.requireNonNull(input, error());
    }
}
