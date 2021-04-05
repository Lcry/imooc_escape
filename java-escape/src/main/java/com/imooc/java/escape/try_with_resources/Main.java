package com.imooc.java.escape.try_with_resources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;

/**
 * <h1>解决使用 try finally 的资源泄露隐患</h1>
 * */
public class Main {

    /**
     * <h2>传统的方式实现对资源的关闭</h2>
     * */
    private String traditionalTryCatch() throws IOException {

        // 1. 单一资源的关闭
//        String line = null;
//        BufferedReader br = new BufferedReader(new FileReader(""));
//        try {
//            line = br.readLine();
//        } finally {
//            br.close();
//        }
//        return line;

        // 2. 多个资源的关闭
        // 第一个资源
        InputStream in = new FileInputStream("");
        try {
            // 第二个资源
            OutputStream out = new FileOutputStream("");
            try {
                byte[] buf = new byte[100];
                int n;

                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }

        return null;
    }

    /**
     * <h2>java7 引入的 try with resources 实现自动的资源关闭</h2>
     * */
    private String newTryWithResources() throws IOException {

        // 1. 单个资源的使用与关闭
//        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
//            return br.readLine();
//        }

        // 2. 多个资源的使用与关闭
        try (FileInputStream in = new FileInputStream("");
             FileOutputStream out = new FileOutputStream("")
        ) {
            byte[] buffer = new byte[100];
            int n = 0;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
        }
        return null;
    }

    public static void main(String[] args) throws MyException {

//        AutoClose autoClose = new AutoClose();
//        try {
//            autoClose.work();
//        } finally {
//            autoClose.close();
//        }

        try (AutoClose autoClose = new AutoClose()) {
            autoClose.work();
        }
    }
}
