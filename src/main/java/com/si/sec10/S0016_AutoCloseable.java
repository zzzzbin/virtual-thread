package com.si.sec10;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S0016_AutoCloseable implements AutoCloseable {
    static final Logger log = LoggerFactory.getLogger(S0016_AutoCloseable.class.getName());
    public static void main(String[] args) throws Exception {
        try(var a = new S0016_AutoCloseable()){

        }
    }

    @Override
    public void close() throws Exception {
        log.info("Closing");
    }
}
