package com.imooc.spring.escape.service;

import com.imooc.spring.escape.default_singleton.DefaultImoocerManagerService;
import com.imooc.spring.escape.util.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDefaultSingleton {

    @Test
    public void testDefaultSingleton() {

        DefaultImoocerManagerService service01 = ApplicationUtils.getBean(
                DefaultImoocerManagerService.class
        );
        DefaultImoocerManagerService service02 = ApplicationUtils.getBean(
                DefaultImoocerManagerService.class
        );

        service01.addImoocer("KunKun");
        service01.addImoocer("Cousin");
        log.info("Service01 Has Imoocers: {}", service01.getImoocers());

        service02.addImoocer("DaMiao");
        log.info("Service01 Has Imoocers: {}", service01.getImoocers());
    }

    @Test
    public void testDefaultSingleton_() {

        DefaultImoocerManagerService service01 = ApplicationUtils.getBean(
                DefaultImoocerManagerService.class
        );
        DefaultImoocerManagerService service02 = ApplicationUtils.getBean(
                DefaultImoocerManagerService.class
        );

        assert service01.hashCode() == service02.hashCode();
    }
}
