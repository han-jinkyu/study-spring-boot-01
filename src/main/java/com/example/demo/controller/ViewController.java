package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ViewController
 */
@Controller
public class ViewController {

    /**
     * templates/index.html을 불러온다
     * @return
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}