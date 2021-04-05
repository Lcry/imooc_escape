package com.imooc.java.escape.lombok_;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <h1>lombok 工具的使用以及需要避免的坑</h1>
 * */
public class Main {

    /**
     * <h1>lombok 第一个坑</h1>
     * */
    private static void singleAlphabetHump() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Personal personal = new Personal();
        personal.setIPhone("8.1");

        // {"name":null,"userName":null,"iphone":"8.1"}
//        System.out.println(mapper.writeValueAsString(personal));

        String json = "{\"name\": \"qinyi\"," +
                "\"userName\": \"qinyi-imooc\",\"iphone\":\"8.1\"}";

        Personal personal1 = mapper.readValue(json, Personal.class);
        System.out.println(personal1);
    }

    /**
     * <h2>lombok 的第二个坑</h2>
     * */
    private static void equalsAndHashCodeBug() {

        AppleComputer computer1 = new AppleComputer(
                1, "Mac Pro", 1L, "yellow"
        );
        AppleComputer computer2 = new AppleComputer(
                2, "Mac Air", 1L, "yellow"
        );

        System.out.println(computer1.equals(computer2));
    }

    public static void main(String[] args) throws Exception {

//        singleAlphabetHump();

        equalsAndHashCodeBug();
    }
}
