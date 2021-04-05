package com.imooc.spring.escape.service;

import com.imooc.spring.escape.async_task.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAsyncTask {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsyncProcess() throws Exception {

//        asyncService.asyncProcess01();
        Future<String> future = asyncService.asyncProcess02();
        log.info("Async Process 02 Return: {}", future.get(
                1, TimeUnit.SECONDS
        ));
    }

    @Test
    public void testAsyncException() throws Exception {

        asyncService.asyncProcess03();
        Thread.sleep(3000);
    }
}
