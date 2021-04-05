package com.imooc.spring.escape.service;

import org.springframework.stereotype.Service;

/**
 * <h1>Spring Bean 的默认名称生成策略</h1>
 * */
@Service("qYImooc")
public class QYImooc {

    public void print() {
        System.out.println("QYImooc");
    }
}
