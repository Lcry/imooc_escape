package com.imooc.spring.escape.date_se_de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

@Configuration
public class DateConverterConfig {

    @Bean
    public DateJacksonConverter dateJacksonConverter() {
        return new DateJacksonConverter();
    }

    @Bean
    public Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean(
            @Autowired DateJacksonConverter dateJacksonConverter
    ) {
        Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean =
                new Jackson2ObjectMapperFactoryBean();
        jackson2ObjectMapperFactoryBean.setDeserializers(dateJacksonConverter);

        return jackson2ObjectMapperFactoryBean;
    }
}
