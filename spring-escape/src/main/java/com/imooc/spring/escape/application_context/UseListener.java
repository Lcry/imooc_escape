package com.imooc.spring.escape.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class UseListener implements ApplicationListener<ApplicationContextEvent> {

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {

        assert ApplicationContextStore.getApplicationContext() == null;
        ApplicationContextStore.setApplicationContext(
                event.getApplicationContext()
        );
        assert ApplicationContextStore.getApplicationContext() != null;
        log.info("UseListener Done.");
    }
}
