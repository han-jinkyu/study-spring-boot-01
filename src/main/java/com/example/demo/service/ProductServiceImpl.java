package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * ProductionRepository
     */
    @Autowired
    ProductRepository productRepository;

    /**
     * 상품을 등록한다
     * @param product 등록할 상품
     */
    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    /**
     * 상품을 갱신한다
     * @param id 갱신할 상품의 ID
     * @param product 갱신할 상품 정보
     */
    @Override
    public void updateProduct(Long id, Product product) {
        product.setId(id);
        productRepository.save(product);
    }

    /**
     * 상품을 삭제한다
     * @param id 삭제할 상품의 ID
     */
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * 상품 리스트를 취득한다
     * @return 상품 리스트
     */
    @Override
    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }
}