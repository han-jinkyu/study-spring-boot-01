package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProductServiceInterceptor
 */
@Component
public class ProductServiceInterceptor implements HandlerInterceptor {

    /**
     * 리퀘스트와 리스폰스 처리가 모두 끝나고 난 뒤에 처리되는 메소드
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("Request and Response is completed");
    }

    /**
     * 리스폰스가 보내지기 직전에 처리되는 메소드
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method is calling");
    }

    /**
     * 리퀘스트가 처리되기 직전에 처리되는 메소드
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Pre Handle method is calling");
        return true;
    }

}