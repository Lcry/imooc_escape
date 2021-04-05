package com.imooc.spring.escape.service;

import com.imooc.spring.escape.bean_post_processor.AVIDecoder;
import com.imooc.spring.escape.bean_post_processor.DecoderManager;
import com.imooc.spring.escape.bean_post_processor.ThirdPartyClass;
import com.imooc.spring.escape.bean_post_processor.VideoType;
import com.imooc.spring.escape.bean_post_processor.WMVDecoder;
import com.imooc.spring.escape.util.ApplicationUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBeanPostProcessor {

    @Autowired
    private AVIDecoder aviDecoder;
    @Autowired
    private WMVDecoder wmvDecoder;

    @Test
    public void testEasyUseDecoder() {

        VideoType type = getRandomVideoType();

        switch (type) {
            case AVI:
                log.info(aviDecoder.decode("video"));
                break;
            case WMV:
                log.info(wmvDecoder.decode("video"));
                break;
            default:
                log.info("error");
        }
    }

    @Autowired
    private DecoderManager decoderManager;

    @Test
    public void testUseDecoderManager() {

        log.info(decoderManager.decode(getRandomVideoType(), "video"));
    }

    /**
     * <h2>获取随机的 VideoType</h2>
     * */
    private VideoType getRandomVideoType() {

        return VideoType.values()[new Random().nextInt(VideoType.values().length)];
    }

    @Test
    public void testCheckBeanFactoryPostProcessor() {

        ThirdPartyClass class01 = ApplicationUtils.getBean(ThirdPartyClass.class);
        ThirdPartyClass class02 = ApplicationUtils.getBean(ThirdPartyClass.class);

        System.out.println(class01.hashCode());
        System.out.println(class02.hashCode());
    }
}
