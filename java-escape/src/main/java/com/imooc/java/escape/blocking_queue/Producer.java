package com.imooc.java.escape.blocking_queue;

import java.util.concurrent.BlockingQueue;

/**
 * <h1>生产者</h1>
 * */
public class Producer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;
    private static int element = 0;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

//    @Override
//    public void run() {
//
//        while (element < 100) {
//            System.out.println("Produce: " + element);
//            blockingQueue.offer(element++);
//        }
//
//        System.out.println("Produce Done!");
//    }

    @Override
    public void run() {

        try {
            while (element < 100) {
                System.out.println("Produce: " + element);
                blockingQueue.put(element++);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Produce Done!");
    }
}
