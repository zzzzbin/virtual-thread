package com.si.sec10;

public class S0020_Assert {
    public static void main(String[] args) {
        parameterNeeded(null);
    }

    private static void parameterNeeded(String input) {
        assert input != null;
    }
}
