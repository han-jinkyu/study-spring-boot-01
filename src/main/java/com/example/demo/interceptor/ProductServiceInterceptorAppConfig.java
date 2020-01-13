package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ProductServiceInterceptorAppConfig
 */
@Component
public class ProductServiceInterceptorAppConfig implements WebMvcConfigurer {

    /**
     * ProductServiceInterceptor
     */
    @Autowired
    ProductServiceInterceptor productServiceInterceptor;

    /**
     * 인터셉터를 등록한다
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productServiceInterceptor);
    }

}