package com.imooc.spring.escape.http_status_code;

import com.imooc.spring.escape.transaction_lost.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>自定义返回状态码</h1>
 * */
@RestController
@RequestMapping("/custom")
public class CustomStatusCodeController {

    /**
     * <h2>第一种方式自定义返回状态码</h2>
     * */
    @GetMapping("/first")
    public ResponseEntity<GeneralResponse<String>> first() {

        GeneralResponse<String> result = new GeneralResponse<>(0, "");
        result.setData("first");

        // 400
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    /**
     * <h2>第二种方式自定义返回状态码</h2>
     * */
    @GetMapping("/second")
    public GeneralResponse<String> second() {
        // 业务逻辑
        throw new BadRequestException();
    }

    /**
     * <h2>第三种方式自定义返回状态码</h2>
     * */
    @GetMapping("/third")
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "current http request 404")
    public void response404() {

    }

    /**
     * <h2>第四种方式自定义返回状态码</h2>
     * */
    @GetMapping("/fourth")
    public GeneralResponse<String> fourth() throws CustomException {
        throw new CustomException("some error");
    }
}
