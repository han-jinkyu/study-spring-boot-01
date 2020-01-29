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
     * @return 파일명
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    /**
     * templates/locale.html을 불러온다
     * @return 파일명
     */
    @RequestMapping(value = "/locale")
    public String locale() {
        return "locale";
    }

    /**
     * templates/user/index.html을 불러온다
     * @return 파일명
     */
    @RequestMapping(value = "/user/index")
    public String userIndex() {
        return "user/index";
    }
}