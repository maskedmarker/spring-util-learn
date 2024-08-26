package org.example.learn.spring.util.basic.net.uri;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentsBuilderTest {

    @Test
    public void test0() {
        String path = "https://httpbin.org/get";
        MultiValueMap queryParams = new LinkedMultiValueMap();
        queryParams.add("goodsTag", "电子类");
        queryParams.add("goodsTag", "3C类");
        queryParams.add("amount", "3");

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(path);
        uriComponentsBuilder.queryParams(queryParams);
        String uriString = uriComponentsBuilder.build().toUriString();
        System.out.println("uriString = " + uriString);

        // encode
        uriComponentsBuilder = UriComponentsBuilder.fromPath(path);
        uriComponentsBuilder.queryParams(queryParams);
        uriComponentsBuilder.encode();
        uriString = uriComponentsBuilder.build().toUriString();
        System.out.println("uriString = " + uriString);
    }

    @Test
    public void test1() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        String uriString = uriComponentsBuilder.scheme("http")
                .host("httpbin.org")
                .path("get")
                .queryParam("goodsTag", "电子类")
                .queryParam("goodsTag", "3C类")
                .queryParam("amount", "3")
                .build()
                .encode()
                .toUriString();
        System.out.println("uriString = " + uriString);
    }

    @Test
    public void test2() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        String uriString = uriComponentsBuilder.scheme("http")
                .host("httpbin.org")
                .path("get")
                .query("goodsTag=电子类&goodsTag=3C类")
                .query("amount=3")
                .build()
                .encode()
                .toUriString();
        System.out.println("uriString = " + uriString);
    }
}
