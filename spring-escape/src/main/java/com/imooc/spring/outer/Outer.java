package com.imooc.spring.outer;

import org.springframework.stereotype.Component;

/**
 * <h1>在默认扫描机制之外定义的 Bean</h1>
 * */
@Component
public class Outer {

    public void print() {
        System.out.println("This is An Outer Class!");
    }
}
