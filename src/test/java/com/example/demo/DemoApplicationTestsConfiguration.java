package com.example.demo;

import com.example.demo.service.ProductService;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * DemoApplicationTestsConfiguration
 */
@Profile("test")
@Configuration
public class DemoApplicationTestsConfiguration {

    @Bean
    @Primary
    public ProductService productService() {
        return Mockito.mock(ProductService.class);
    }
}