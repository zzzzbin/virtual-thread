package com.si.sec10;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

public class S0102_OpenURIInBrowser {
    @interface Dev{}
    static void main(String... args) throws IOException {
        var uri = URI
                .create("https://airhacks.live");
        Desktop.getDesktop().browse(uri);
        var superclass = Dev.class.getInterfaces();
        System.out.println(Arrays.toString(superclass));
    }
}
