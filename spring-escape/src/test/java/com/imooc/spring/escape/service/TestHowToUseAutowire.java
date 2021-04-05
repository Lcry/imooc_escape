package com.imooc.spring.escape.service;

import com.imooc.spring.escape.util.ApplicationUtils;
import com.imooc.spring.outer.Outer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestHowToUseAutowire {

    @Test
    public void firstTryTest() {

        assert ApplicationUtils.getApplicationContext().containsBean("qYImooc");
        HowToUseAutowire useAutowire = new HowToUseAutowire();
        useAutowire.print();
    }

    @Test
    public void secondTryTest() {

        assert ApplicationUtils.getApplicationContext().containsBean("qYImooc");
        HowToUseAutowire useAutowire = new HowToUseAutowire();
        useAutowire.print();
    }

    @Test
    public void thirdTryTest() {

        assert ApplicationUtils.getApplicationContext().containsBean("qYImooc");
        HowToUseAutowire useAutowire = ApplicationUtils.getBean(
                HowToUseAutowire.class
        );
        useAutowire.print();
    }

    @Test
    public void fourthTryTest() {

        assert ApplicationUtils.getApplicationContext().containsBean("outer");
        ((Outer) ApplicationUtils.getBean("outer")).print();
    }
}
