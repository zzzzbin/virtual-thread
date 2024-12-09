package com.si.sec10;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class S0059_FetchAsyncHttpClient {
    public static void main(String[] args) {
        var uri = URI.create("https://airhacks.fm");
        fetch(uri);
    }
    static void onFetch(String content) {
        System.out.println(content);
    }
    private static void fetch(URI uri) {
        try(var httpClient = HttpClient.newHttpClient()){
            var req = HttpRequest.newBuilder(uri)
                    .GET()
                    .build();
            httpClient
                    .sendAsync(req, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(S0059_FetchAsyncHttpClient::onFetch);
        }
    }
}
