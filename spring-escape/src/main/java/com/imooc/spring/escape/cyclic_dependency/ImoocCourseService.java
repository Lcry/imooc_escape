package com.imooc.spring.escape.cyclic_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ImoocCourseService {

//    private final QinyiJavaService javaService;
//
//    @Autowired
//    public ImoocCourseService(QinyiJavaService javaService) {
//        this.javaService = javaService;
//    }

    // Field
    @Autowired
    private QinyiJavaService javaService;

    // setter
//    @Autowired
//    public void setQinyiJavaService(QinyiJavaService javaService) {
//        this.javaService = javaService;
//    }

    public void imoocCourse() {
        javaService.qinyiJava();
    }
}
