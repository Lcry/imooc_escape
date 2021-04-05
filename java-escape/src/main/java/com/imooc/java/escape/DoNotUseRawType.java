package com.imooc.java.escape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>不要使用原始类型</h1>
 * */
@SuppressWarnings("all")
public class DoNotUseRawType {

    /**
     * <h2>简单使用原始类型</h2>
     * */
    private static void simpleExample() {

        List data = new ArrayList();
        data.add("qinyi");
        data.add(19);
        data.add("Hello Imooc");

//        data.forEach(System.out::println);
//
//        data.forEach(d -> {
//
//            if (((String) d).equals("Hello Imooc")) {
//                System.out.println(data.indexOf(d));
//            }
//
//        });

        data.forEach(d -> {

            if (d instanceof String && ((String) d).equals("Hello Imooc")) {
                System.out.println(data.indexOf(d));
            }

        });
    }

    /**
     * <h2>优化使用原始类型</h2>
     * */
    private static void optimizeUse() {

//        List<Object> data = new ArrayList();
//        data.add("qinyi");
//        data.add(19);
//        data.add("Hello Imooc");
//
//        data.forEach(System.out::println);

        List<People> data = new ArrayList<>();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class People {

        private String name;
        private Integer age;
        private String signature;
    }

    public static void main(String[] args) {

        simpleExample();
    }
}
