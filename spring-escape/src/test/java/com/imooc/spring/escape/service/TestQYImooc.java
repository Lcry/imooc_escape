package com.imooc.spring.escape.service;

import com.imooc.spring.escape.util.ApplicationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>测试 Spring Bean 默认名称生成策略</h1>
 * */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestQYImooc {

    @Test
    public void testDefaultBeanName() {

        QYImooc qyImooc = (QYImooc) ApplicationUtils.getBean("QYImooc");

        QYImooc qyImooc_ = ApplicationUtils.getBean(QYImooc.class);
        qyImooc.print();
    }
}
