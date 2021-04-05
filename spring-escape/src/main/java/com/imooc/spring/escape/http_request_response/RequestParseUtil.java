package com.imooc.spring.escape.http_request_response;

import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class RequestParseUtil {

    /**
     * <h2>当前的请求是否是 rest 类型</h2>
     * */
    public static boolean isJson(HttpServletRequest request) {

        if (request.getContentType() != null) {
            return request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)
                    || request.getContentType()
                    .equals(MediaType.APPLICATION_JSON_UTF8_VALUE);
        }

        return false;
    }

    public static String getBodyString(final ServletRequest request) {
        try {
            return inputStream2String(request.getInputStream());
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    private static String inputStream2String(InputStream inputStream) {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;

        try {

            reader = new BufferedReader(
                    new InputStreamReader(inputStream, Charset.defaultCharset())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }

        return sb.toString();
    }
}
