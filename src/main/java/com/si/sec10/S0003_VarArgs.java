package com.si.sec10;

public interface S0003_VarArgs {

    static void main(String[] args) {
        S0003_VarArgs.hello("hey", "duke", "java");
        hello("is", "working");
        hello(new String[]{"is","always", "working"});
    }

    static void hello(String... messages) {
        for(var message: messages) {
            System.out.println(message);
        }
    }
}
