package com.imooc.spring.escape.async_task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncService {

    @Async
    public void asyncProcess01() throws Exception {

        log.info("AsyncService: Start To Process 01 -> {}",
                Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("AsyncService: Done To Process 01 -> {}",
                Thread.currentThread().getName());
    }

    @Async
    public Future<String> asyncProcess02() throws Exception {

        log.info("AsyncService: Start To Process 02 -> {}",
                Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("AsyncService: Done To Process 02 -> {}",
                Thread.currentThread().getName());

        return new AsyncResult<>("ImoocQinyi");
    }

    @Async
    public void asyncProcess03() throws Exception {

        log.info("AsyncService: Start To Process 03 -> {}",
                Thread.currentThread().getName());
        Thread.sleep(2000);
        throw new RuntimeException("throw exception in asyncProcess03.");
    }
}
