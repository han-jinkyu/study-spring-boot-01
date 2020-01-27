package com.example.demo.model;

/**
 * 상품
 */
public class Product {

    /**
     * 상품ID
     */
    private String id;

    /**
     * 상품명
     */
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
    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * ID를 취득한다
     * 
     * @return 상품ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID를 저장한다
     * 
     * @param id 저장할 ID
     */
    public void setId(String id) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Product)) {
            return false;
        }

        Product cmp = (Product)obj;

        if (this.id != cmp.getId()) {
            return false;
        }

        if (this.name != cmp.getName()) {
            return false;
        }

        return true;
    }
}