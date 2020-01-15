package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.model.Product;

import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {

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
     * 상품을 등록한다
     * @param product 등록할 상품
     */
    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    /**
     * 상품을 갱신한다
     * @param id 갱신할 상품의 ID
     * @param product 갱신할 상품 정보
     */
    @Override
    public void updateProduct(String id, Product product) {
        product.setId(id);
        productRepo.replace(id, product);
    }

    /**
     * 상품을 삭제한다
     * @param id 삭제할 상품의 ID
     */
    @Override
    public void deleteProduct(String id) {
        productRepo.remove(id);
    }

    /**
     * 상품 리스트를 취득한다
     * @return 상품 리스트
     */
    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }
}