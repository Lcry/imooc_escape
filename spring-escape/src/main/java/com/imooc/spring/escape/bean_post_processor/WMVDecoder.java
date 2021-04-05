package com.imooc.spring.escape.bean_post_processor;

import org.springframework.stereotype.Service;

@Service
public class WMVDecoder implements IDecoder {

    @Override
    public VideoType type() {
        return VideoType.WMV;
    }

    @Override
    public String decode(String data) {
        return this.type().getDesc() + ": " + data;
    }
}
