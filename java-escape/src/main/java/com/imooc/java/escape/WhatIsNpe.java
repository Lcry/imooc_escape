package com.imooc.java.escape;

/**
 * <h1>理解什么是空指针</h1>
 * */
public class WhatIsNpe {

    public static class User {

        private String name;
        private String[] address;

        public void print() {
            System.out.println("This is User Class!");
        }

        public String readBook() {
            System.out.println("User Read Imooc Escape!");
            return null;
        }
    }

    /**
     * <h2>自定义一个运行时异常</h2>
     * */
    public static class CustomException extends RuntimeException {}

    public static void main(String[] args) {

        // 第一种情况: 调用了空对象的实例方法
//        User user = null;
//        user.print();

        // 第二种情况: 访问了空对象的属性
//        User user = null;
//        System.out.println(user.name);

        // 第三种情况: 当数组是一个空对象的时候, 取它的长度
//        User user = new User();
//        System.out.println(user.address.length);

        // 第四种情况: null 当做 Throwable 的值
//        CustomException exception = null;
//        throw exception;

        // 第五种情况: 方法的返回值是 null, 调用方直接去使用
        User user = new User();
        System.out.println(user.readBook().contains("MySQL"));
    }
}
