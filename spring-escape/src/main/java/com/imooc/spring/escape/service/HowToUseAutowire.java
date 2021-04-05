package com.imooc.spring.escape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h1>学会使用 @Autowired 注解</h1>
 * */
@Component
public class HowToUseAutowire {

    @Autowired
    private QYImooc imooc;

    public void print() {
        imooc.print();
    }
}
