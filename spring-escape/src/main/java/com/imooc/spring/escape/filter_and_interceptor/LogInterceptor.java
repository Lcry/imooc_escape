package com.imooc.spring.escape.filter_and_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

    long start = System.currentTimeMillis();

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {

        start = System.currentTimeMillis();

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        log.info("LogInterceptor: {}", ((HandlerMethod) handler).getBean()
                .getClass().getName());
        log.info("LogInterceptor: {}", handlerMethod.getMethod().getName());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("LogInterceptor Print Log: {} -> {}",
                request.getRequestURI(),
                System.currentTimeMillis() - start);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
