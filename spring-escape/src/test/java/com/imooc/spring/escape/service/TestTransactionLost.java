package com.imooc.spring.escape.service;

import com.imooc.spring.escape.transaction_lost.CustomException;
import com.imooc.spring.escape.transaction_lost.ISpringTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTransactionLost {

    @Autowired
    private ISpringTransaction springTransaction;

    @Test
    public void testCatchExceptionCanNotRollback() {

        springTransaction.CatchExceptionCanNotRollback();
    }

    @Test
    public void testNotRuntimeExceptionCanNotRollback() throws CustomException {

        springTransaction.NotRuntimeExceptionCanNotRollback();
    }
}
