package com.si.sec10;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S0104_HtmlList {
    static void main(String... args) {
        var html = Stream
                .of("write","compile","test","delete")
                .map("<li>%s</li>"::formatted)
                .collect(Collectors.joining("\n","<ol>\n","\n</ol>"));
        System.out.println(html);
    }
}
