package com.imooc.java.escape.thread_local;

/**
 * <h1>ThreadLocal 的使用和对它的理解</h1>
 * */
public class Main {

    /**
     * <h2>ThreadLocal 不支持继承</h2>
     * */
    private static void threadLocalCanNotInherit() {

        ThreadLocal<String> name = new ThreadLocal<>();
        name.set("qinyi");

        Thread sub = new Thread(() -> System.out.println("Name In Sub: " + name.get()));
        sub.start();

        System.out.println("Name In Main: " + name.get());
    }

    public static void main(String[] args) {

//        for (int i = 0; i != 3; ++i) {
//
//            new Thread(
//                    () -> {
//                        DoCompetition competition = new DoCompetition();
//                        competition.code();
//                        competition.config();
//                        competition.print();
//                    }, "Thread-" + (i + 1)
//            ).start();
//        }

        threadLocalCanNotInherit();
    }
}
