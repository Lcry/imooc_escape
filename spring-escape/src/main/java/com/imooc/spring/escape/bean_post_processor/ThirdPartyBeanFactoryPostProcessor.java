package com.imooc.spring.escape.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class ThirdPartyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition(
                "thirdPartyClass");
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}
