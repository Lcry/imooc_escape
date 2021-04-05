package com.imooc.spring.escape.more_config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@ConfigurationProperties(prefix = "escape.user")
public class UserProperties {

    private String name;
    private Integer age;
}
