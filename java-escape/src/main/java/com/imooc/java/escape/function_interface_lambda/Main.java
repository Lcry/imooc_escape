package com.imooc.java.escape.function_interface_lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>函数式接口的使用</h1>
 * */
@SuppressWarnings("all")
public class Main {

    private static final Map<Long, Worker> id2WorkerMap = new HashMap<>();

    static {
        id2WorkerMap.put(1L, new Worker(1L, "qinyi", 19));
    }

    public static void main(String[] args) {

//        IFindWorker findWorker = id -> id2WorkerMap.get(id);

        IFindWorker findWorker = id2WorkerMap::get;

        System.out.println(findWorker.findWorkerById(1L));
    }
}
