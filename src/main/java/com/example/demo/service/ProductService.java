package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Product;

/**
 * ProductService
 */
public interface ProductService {

    /**
     * 상품을 등록한다
     * @param product 등록할 상품
     */
    public abstract void createProduct(Product product);

    /**
     * 상품을 갱신한다
     * @param id 갱신할 상품의 ID
     * @param product 갱신할 상품 정보
     */
    public abstract void updateProduct(String id, Product product);

    /**
     * 상품을 삭제한다
     * @param id 삭제할 상품의 ID
     */
    public abstract void deleteProduct(String id);

    /**
     * 상품 리스트를 취득한다
     * @return 상품 리스트
     */
    public abstract Collection<Product> getProducts();
}