package com.imooc.spring.escape.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class QinyiJavaService {

//    private final ImoocCourseService courseService;
//
//    @Autowired
//    public QinyiJavaService(ImoocCourseService courseService) {
//        this.courseService = courseService;
//    }

    // Field
    @Autowired
    private ImoocCourseService courseService;

    public void qinyiJava() {
        System.out.println("QinyiJavaService");
    }
}
