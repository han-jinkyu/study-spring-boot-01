package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 상품
 */
@Entity
@Table(name = "PRODUCT")
public class Product {

    /**
     * 상품ID
     */
    @Id
    // IDENTITY는 DB에게 위임하는 형식
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * 상품명
     */
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * 생성자
     */
    public Product() {
    }

    /**
     * 생성자
     * 
     * @param id   상품ID
     * @param name 상품명
     */
    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * ID를 취득한다
     * 
     * @return 상품ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID를 저장한다
     * 
     * @param id 저장할 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 이름을 취득한다
     * 
     * @return 상품명
     */
    public String getName() {
        return name;
    }

    /**
     * 이름을 저장한다
     * 
     * @param name 저장할 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 상품을 비교한다
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Product)) {
            return false;
        }

        Product cmp = (Product) obj;

        if (this.id != cmp.getId()) {
            return false;
        }

        if (this.name != cmp.getName()) {
            return false;
        }

        return true;
    }

    /**
     * 스트링으로 변경한다
     */
    @Override
    public String toString() {
        return String.format("Product[id='%d', name='%s']", id, name);
    }
}