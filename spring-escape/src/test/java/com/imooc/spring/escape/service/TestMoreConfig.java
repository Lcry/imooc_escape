package com.imooc.spring.escape.service;

import com.imooc.spring.escape.more_config.UserProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMoreConfig {

    @Autowired
    private UserProperties properties;

    @Test
    public void printUserProperties() {

        System.out.println(properties.toString());
    }
}
