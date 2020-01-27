package com.example.demo;

import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * DemoApplicationTestsConfiguration
 */
@Configuration
@Profile("test")
public class DemoApplicationTestsConfiguration {

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }
}