package com.imooc.spring.escape.bean_post_processor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VideoType {

    AVI("AVI"),
    WMV("WMV");

    // TODO 定义更多的视频类型

    private String desc;
}
