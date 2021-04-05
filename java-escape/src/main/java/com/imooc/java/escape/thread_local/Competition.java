package com.imooc.java.escape.thread_local;

public class Competition {

    public static ThreadLocal<Material> material = ThreadLocal.withInitial(
            () -> new Material("初始代码", "初始配置")
    );

    public static class Material {

        private String code;
        private String config;

        public Material(String code, String config) {
            this.code = code;
            this.config = config;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getConfig() {
            return config;
        }

        public void setConfig(String config) {
            this.config = config;
        }
    }
}
