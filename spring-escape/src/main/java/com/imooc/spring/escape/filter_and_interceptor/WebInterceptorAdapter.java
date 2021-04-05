package com.imooc.spring.escape.filter_and_interceptor;

import com.imooc.spring.escape.http_request_response.User;
import com.imooc.spring.escape.http_request_response.UserIdInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Configuration
public class WebInterceptorAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").order(0);
        registry.addInterceptor(new UpdateLogInterceptor())
                .addPathPatterns("/**").order(1);

        registry.addInterceptor(new UserIdInterceptor()).addPathPatterns("/**")
                .order(3);
    }
}
