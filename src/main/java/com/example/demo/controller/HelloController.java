package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello에 관한 컨트롤러
 */
@RestController
public class HelloController {

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    /**
     * 이름. 프로퍼티로부터 내용을 취득한다
     */ 
    @Value("${spring.application.name:defaultValue}")
    String name;

    /**
     * 헬로
     */
    @RequestMapping
    public String Hello() {
        logger.info("info message!");
        logger.warn("info message!");
        logger.error("info message!");
        return String.format("Hello, %s!", name);
    }
}