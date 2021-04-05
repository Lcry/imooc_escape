package com.imooc.java.escape.threadpool;

import java.util.concurrent.ExecutorService;

/**
 * <h1>可监控的线程池</h1>
 * */
public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = ExecutorsUtil.newFixedThreadPool(
                10, "imooc-qinyi-"
        );

        Runnable runnable01 = new Reading(3, "Java 编程思想");
        Runnable runnable02 = new Reading(2, "Spring 实战");
        Runnable runnable03 = new Reading(3, "SpringBoot 实战");
        Runnable runnable04 = new Reading(1, "MySQL 权威指南");
        Runnable runnable05 = new Reading(2, "SpringCloud 实战");

        executorService.execute(runnable01);
        executorService.execute(runnable02);
        executorService.execute(runnable03);
        executorService.execute(runnable04);
        executorService.execute(runnable05);

        executorService.shutdown();
    }
}
