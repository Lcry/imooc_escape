package com.imooc.spring.escape.multi_usable_bean;

import org.springframework.stereotype.Service;

@Service
public class ImoocTemplateManagerService implements ITemplateManagerService {

    @Override
    public void print() {
        System.out.println("ImoocTemplateManagerService");
    }
}
