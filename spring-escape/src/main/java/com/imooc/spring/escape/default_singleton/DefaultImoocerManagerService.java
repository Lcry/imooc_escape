package com.imooc.spring.escape.default_singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DefaultImoocerManagerService {

    private List<String> imoocers = null;

    @PostConstruct
    public void init() {
        log.info("Coming In DefaultImoocerManagerService init!");
        this.imoocers = new ArrayList<>(100);
    }

    public void addImoocer(String imoocer) {
        this.imoocers.add(imoocer);
    }

    public int imoocerCount() {
        return this.imoocers.size();
    }

    public List<String> getImoocers() {
        return this.imoocers;
    }
}
