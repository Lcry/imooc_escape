package com.imooc.spring.escape.bean_post_processor;

/**
 * <h1>解码器接口定义</h1>
 * */
public interface IDecoder {

    VideoType type();

    String decode(String data);
}
