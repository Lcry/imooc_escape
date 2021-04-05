package com.imooc.spring.escape;

import com.imooc.spring.escape.application_context.ApplicationContextStore;
import com.imooc.spring.escape.application_context.UseIntitiallizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <h1>SpringBoot 启动程序</h1>
 * */
@EnableAsync
//@EnableScheduling
@SpringBootApplication
@ServletComponentScan("com.imooc.spring.escape")
@ComponentScan(value = {"com.imooc.spring.escape", "com.imooc.spring.outer"})
public class SpringEscapeApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringEscapeApplication.class, args);

        // 第一种方式获取应用上下文
//        SpringApplication application = new SpringApplication(
//                SpringEscapeApplication.class
//        );
//        application.addInitializers(new UseIntitiallizer());
//        application.run(args);

        // 第三种方式获取应用上下文
//        ApplicationContextStore.setApplicationContext(
//                SpringApplication.run(SpringEscapeApplication.class, args)
//        );
    }
}
