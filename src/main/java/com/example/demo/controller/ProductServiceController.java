package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductServiceController
 */
@RestController
public class ProductServiceController {

    /**
     * 레포지터리로 사용할 해쉬맵
     */
    private static Map<String, Product> productRepo = new HashMap<>();

    /**
     * 레포지터리에 데이터를 초기화한다
     */
    static {
        Product honey = new Product("1", "Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product("2", "Almond");
        productRepo.put(almond.getId(), almond);
    }

    /**
     * 상품 리스트를 취득한다
     * @return 리스폰스 객체
     */
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    /**
     * 상품을 등록한다
     * @param product 등록할 상품
     * @return 상품 등록이 완료된 후의 리스폰스
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully!", HttpStatus.OK);
    }

    /**
     * 상품을 갱신한다
     * @param id 갱신할 상품의 ID
     * @param product 갱신할 데이터
     * @return 갱신이 완료된 후의 리스폰스
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Product product) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
        product.setId(id);
        productRepo.replace(id, product);
        return new ResponseEntity<>("Product is updated successfully!", HttpStatus.OK);
    }

    /**
     * 상품을 삭제한다
     * @param id 삭제할 상품의 ID
     * @return 삭제가 완료된 후의 리스폰스
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully!", HttpStatus.OK);
    }
}