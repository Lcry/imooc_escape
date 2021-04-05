package com.imooc.java.escape.function_interface_lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>Lambda 表达式的使用</h1>
 * */
public class StudyLambda {

    /**
     * <h2>Java 1.8 之前创建线程</h2>
     * */
    private static void baseUse() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Class Thread run()");
            }
        }).start();
    }

    /**
     * <h2>Java8 创建线程</h2>
     * */
    private static void easyUseLambda() {

        new Thread(() -> System.out.println("Anonymous Class Thread run()")).start();
    }

    /**
     * <h2>按照字符串长度进行排序</h2>
     * */
    private static void myCompare() {

        // java8 之前
        List<String> list = Arrays.asList("z", "y", "x", "a");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                if (s1 == null)
                    return -1;
                if (s2 == null)
                    return 1;
                return s1.length() - s2.length();
            }
        });

        // java8 使用 lambda 表达式去实现
        Collections.sort(list, (s1, s2) -> {
            if (s1 == null)
                return -1;
            if (s2 == null)
                return 1;
            return s1.length() - s2.length();
        });
    }

    /**
     * <h2>要理解 stream 的中间操作和结束操作</h2>
     * */
    private static void howToUseLambda() {

        List<String> names = Arrays.asList("qinyi", "imooc");

        List<String> newNames =
                names.stream().filter(n -> n.startsWith("q"))
                .map(n -> n.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(newNames);
    }

    /**
     * <h2>Stream 和 lambda 可能导致计算低效</h2>
     * */
    private static void badUseLambda() {

        List<String> names = Arrays.asList("qinyi", "imooc");

        int longestNameSize =
                names.stream()
                .filter(s -> s.startsWith("q"))
                .mapToInt(String::length)
                .max()
                .getAsInt();

        int longest = 0;
        for (String str : names) {
            if (str.startsWith("q")) {
                int len = str.length();
                longest = Math.max(len, longest);
            }
        }

        System.out.println(longest);
    }
}
