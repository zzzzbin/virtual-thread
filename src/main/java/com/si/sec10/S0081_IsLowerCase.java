package com.si.sec10;

import java.util.stream.IntStream;

import static java.lang.Character.getName;
import static java.lang.Character.toChars;

public class S0081_IsLowerCase {
    record Emoji(int codePoint) {
        String name() {
            return getName(codePoint)
                    .toLowerCase();
        }

        String emoji() {
            return String.valueOf(toChars(codePoint));
        }

        public String toString() {
            return "%s -> %s".formatted(name(), emoji());
        }
    }

    static void main(String... args) {
        var isLowerCase = "heyduke"
                .chars()
                .allMatch(Character::isLowerCase);

        System.out.println(isLowerCase);

        IntStream.range(0, Integer.MAX_VALUE)
                .filter(Character::isEmoji)
                .mapToObj(Emoji::new)
                .forEach(System.out::println);

    }
}
