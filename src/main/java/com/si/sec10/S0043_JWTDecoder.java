package com.si.sec10;

import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S0043_JWTDecoder {
    public static void main(String[] args) {
        var parts = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
                .split("\\.");
        var result = Stream.of(parts)
                .limit(2)
                .map(Base64.getDecoder()::decode)
                .map(String::new)
                .collect(Collectors.joining(","));
        System.out.println(result);

    }
}
