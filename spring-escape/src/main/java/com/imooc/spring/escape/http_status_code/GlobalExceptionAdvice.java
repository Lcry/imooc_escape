package com.imooc.spring.escape.http_status_code;

import com.imooc.spring.escape.transaction_lost.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>全局统一异常处理</h1>
 * */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<GeneralResponse<String>> handleCustomException(
            HttpServletRequest request, CustomException ex
    ) {

        GeneralResponse<String> result = new GeneralResponse<>(0, "");
        result.setData(ex.getMessage());

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
