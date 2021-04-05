package com.imooc.java.escape;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <h1>多线程下的变量值更新</h1>
 * */
public class Atomic_ {

    private static int count = 0;
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    /**
     * <h2>线程不安全的累加</h2>
     * */
    private static void accumulator(int acc) throws Exception {

        CountDownLatch cd1 = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int j = 0; j < acc; ++j) {
                    count++;
                }
                cd1.countDown();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int j = 0; j < acc; ++j) {
                    count++;
                }
                cd1.countDown();
            }
        });

        t1.start();
        t2.start();

        cd1.await();

        System.out.println("result: " + count);
    }

    private static void atomicAccumulator(int acc) throws Exception {

        CountDownLatch cd1 = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int j = 0; j < acc; ++j) {
                    atomicCount.incrementAndGet();
                }
                cd1.countDown();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int j = 0; j < acc; ++j) {
                    atomicCount.incrementAndGet();;
                }
                cd1.countDown();
            }
        });

        t1.start();
        t2.start();

        cd1.await();

        System.out.println("result: " + atomicCount.get());
    }

    public static void main(String[] args) throws Exception {

        accumulator(20000);

//        atomicAccumulator(10000);
    }
}
