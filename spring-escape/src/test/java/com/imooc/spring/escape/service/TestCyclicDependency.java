package com.imooc.spring.escape.service;

import com.imooc.spring.escape.cyclic_dependency.ImoocCourseService;
import com.imooc.spring.escape.cyclic_dependency.QinyiJavaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCyclicDependency {

    @Autowired
    private QinyiJavaService javaService;

    @Autowired
    private ImoocCourseService courseService;

    @Test
    public void testCyclicDependency() {

        javaService.qinyiJava();
        courseService.imoocCourse();
    }
}
