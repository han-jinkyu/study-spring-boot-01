package com.example.demo.repository;

import com.example.demo.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 * 
 * JPA를 사용하여 만드는 레포지터리. 아래 URL을 참조하자.
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface
 * 
 * JpaRepository를 계승하면 기본적인 메소드를 사용할 수 있다!
 * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Query를 만들기 위해서는 정해진 키워드를 사용하여 메소드를 작성하여야 한다.
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
}