package org.example.learn.spring.util.basic.net.client;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate是个模板类,仅仅提供了发送http请求/处理http响应的模板步骤.
 * RestTemplate对象创建后,内部状态是不会改变的.
 * 每个请求都具有不同的状态,这部分由ClientHttpRequestFactory来将请求封装成不同的独立ClientHttpRequest对象,
 * 所以RestTemplate是线程安全的
 */
public class RestTemplateTest {


    @Test
    public void test0() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://www.baidu.com";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        HttpHeaders headers = responseEntity.getHeaders();
        String body = responseEntity.getBody();
        headers.entrySet().forEach(System.out::println);
        System.out.println("-----------------------");
        System.out.println("body = " + body);
    }

    @Test
    public void test1() {
        // RestTemplate默认使用的是SimpleClientHttpRequestFactory
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setBufferRequestBody(false);

        // 可以为RestTemplate设置定制化的ClientHttpRequestFactory
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        String url = "http://www.baidu.com";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        HttpHeaders headers = responseEntity.getHeaders();
        String body = responseEntity.getBody();
        headers.entrySet().forEach(System.out::println);
        System.out.println("-----------------------");
        System.out.println("body = " + body);
    }
}
