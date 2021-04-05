package com.imooc.spring.escape.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <h1>应用上下文工具类</h1>
 * */
@Slf4j
@Component
public class ApplicationUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        if (ApplicationUtils.applicationContext == null) {
            ApplicationUtils.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return ApplicationUtils.applicationContext;
    }

    /**
     * <h2>通过 name 获取 Bean</h2>
     * */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * <h2>通过 class 获取 Bean</h2>
     * */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * <h2>通过 name + class 获取 Bean</h2>
     * */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
