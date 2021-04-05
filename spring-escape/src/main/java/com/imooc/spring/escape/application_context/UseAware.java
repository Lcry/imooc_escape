package com.imooc.spring.escape.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class UseAware implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        assert ApplicationContextStore.getApplicationContext() == null;
        ApplicationContextStore.setApplicationContext(
                applicationContext
        );
        assert ApplicationContextStore.getApplicationContext() != null;
        log.info("UseAware Done.");
    }
}
