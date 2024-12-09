package com.si.sec10;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;

public class S0073_ListOfDifferentImpls {
    public static void main(String[] args) {
        var two = List.of(1,2);
        var three = List.of(1,2,3);
        System.out.println(two.getClass());
        System.out.println(three.getClass());

        var workingDirectory = Path
                .of("")
                .toAbsolutePath();
        System.out.println(workingDirectory);

        System.out.println(Character.isEmoji(0));
        IntStream.range(0, Integer.MAX_VALUE)
                .filter(Character::isEmoji)
                .mapToObj(Character::toChars)
                .map(String::valueOf)
                .forEach(System.out::print);

        var bean = ManagementFactory
                .getPlatformMXBean(RuntimeMXBean.class);
        System.out.println("classpath: " + bean.getClassPath());
        System.out.println(System.getProperty("java.class.path"));
    }
}
