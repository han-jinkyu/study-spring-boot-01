package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ProductExceptionController 전역 예외 처리
 */
@ControllerAdvice
public class ProductExceptionController {

    /**
     * 예외 처리를 한다
     * @param exception 예외 객체
     * @return 예외를 처리하고 난 뒤의 리스폰스
     */
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}