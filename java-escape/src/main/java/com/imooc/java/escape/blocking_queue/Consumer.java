package com.imooc.java.escape.blocking_queue;

import java.util.concurrent.BlockingQueue;

/**
 * <h1>消费者</h1>
 * */
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            while (true) {
                int value = blockingQueue.take();
                System.out.println("Consume: " + value);
                if (value >= 99) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Consumer Done!");
    }
}
