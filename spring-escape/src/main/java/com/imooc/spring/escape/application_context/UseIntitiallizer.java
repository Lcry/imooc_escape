package com.imooc.spring.escape.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <h1>第一种方式获取应用上下文</h1>
 * */
@Slf4j
public class UseIntitiallizer implements
        ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        assert ApplicationContextStore.getApplicationContext() == null;
        ApplicationContextStore.setApplicationContext(applicationContext);
        assert ApplicationContextStore.getApplicationContext() != null;
        log.info("UseIntitiallizer Done.");
    }
}
