package com.example.demo.controller;

import java.util.Collection;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
     * ProductService
     */
    @Autowired
    ProductService productService;

    /**
     * 상품 리스트를 취득한다
     * @return 리스폰스 객체
     */
    @RequestMapping(value = "/products")
    // Controller에서 CORS를 활성화하는 방법. CORS는 다른 곳에서 요청을 받아주는 것.
    // CrossOrigin 애노테이션은 이 메소드만 부분 활성화하는 것.
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Object> getProducts() {
        Collection<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * 상품을 등록한다
     * @param product 등록할 상품
     * @return 상품 등록이 완료된 후의 리스폰스
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
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
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully!", HttpStatus.OK);
    }

    /**
     * 상품을 삭제한다
     * @param id 삭제할 상품의 ID
     * @return 삭제가 완료된 후의 리스폰스
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully!", HttpStatus.OK);
    }
}