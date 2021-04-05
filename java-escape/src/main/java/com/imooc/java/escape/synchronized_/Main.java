package com.imooc.java.escape.synchronized_;

/**
 * <h1>多线程操作下的线程安全问题</h1>
 * */
public class Main {

    public static void main(String[] args) {

//        Active active = new Active();

//        MainActive active = new MainActive();

//        SubActive active = new SubActive();
//
//        Thread thread1 = new Thread(active, "thread1");
//        Thread thread2 = new Thread(active, "thread2");
//        Thread thread3 = new Thread(active, "thread3");
//        Thread thread4 = new Thread(active, "thread4");
//        Thread thread5 = new Thread(active, "thread5");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();

        synchronized (Main.class) {
            System.out.println("synchronized");
        }
    }
}
