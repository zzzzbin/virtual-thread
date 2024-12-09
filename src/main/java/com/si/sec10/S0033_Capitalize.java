package com.si.sec10;

public class S0033_Capitalize {
    static String cap(String name) {
        var first = Character.toUpperCase(name.charAt(0));
        var rem = name.substring(1);
        return first + rem;
    }

    static void main(String... args) {
        System.out.println(cap("duke"));
        var home = System.getenv().get("JAVA_HOME");
        System.out.println("home = " + home);
    }
}
