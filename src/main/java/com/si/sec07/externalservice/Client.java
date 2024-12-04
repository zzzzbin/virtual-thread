package com.si.sec07.externalservice;



import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Client {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    private static final String PRODUCT_REQUEST_FORMAT = "http://localhost:7070/sec01/product/%d";
    private static final String RATING_REQUEST_FORMAT = "http://localhost:7070/sec01/rating/%d";

    public static String getProduct(int productId) {
        return callExternalService(PRODUCT_REQUEST_FORMAT.formatted(productId));
    }

    public static Integer getRating(int productId) {
        return Integer.parseInt(callExternalService(RATING_REQUEST_FORMAT.formatted(productId)));
    }
    private static String callExternalService(String url){
        logger.info("Calling external service: {}", url);
        try(var stream = URI.create(url).toURL().openStream()){ //stream should be closed
            return new String(stream.readAllBytes());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {

    }
}
