package com.example.demo.controller;

import java.util.Arrays;

import com.example.demo.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ConsumeWebService
 */
@RestController
public class ConsumeWebService {

    /**
     *  RestTemplate 객체
     */
    @Autowired
    RestTemplate restTemplate;

    /**
     * RestTemplate를 이용하여 상품 리스트를 취득한다
     * @return RestTemplate를 이용한 리스폰스의 바디
     */
    @RequestMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return restTemplate
            .exchange("http://localhost:8080/products", HttpMethod.GET, requestEntity, String.class)
            .getBody();
    }

    /**
     * RestTemplate를 이용하여 상품을 등록한다
     * @param product 등록할 상품
     * @return RestTemplate를 이용한 상품 등록이 완료된 후의 리스폰스
     */
    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Product> requestEntity = new HttpEntity<>(product, headers);

        return restTemplate
            .exchange("http://localhost:8080/products", HttpMethod.POST, requestEntity, String.class)
            .getBody();
    }

    /**
     * RestTemplate를 이용하여 상품을 갱신한다
     * @param id 갱신할 상품의 ID
     * @param product 갱신할 데이터
     * @return RestTemplate를 이용한 갱신이 완료된 후의 리스폰스
     */
    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProducts(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Product> requestEntity = new HttpEntity<>(product, headers);

        return restTemplate
            .exchange(String.format("http://localhost:8080/products/%s", id), HttpMethod.PUT, requestEntity, String.class)
            .getBody();
    }

    /**
     * RestTemplate를 이용하여 상품을 삭제한다
     * @param id 삭제할 상품의 ID
     * @return RestTemplate를 이용한 삭제가 완료된 후의 리스폰스
     */
    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProducts(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Product> requestEntity = new HttpEntity<>(headers);

        return restTemplate
            .exchange(String.format("http://localhost:8080/products/%s", id), HttpMethod.DELETE, requestEntity, String.class)
            .getBody();
    }
}