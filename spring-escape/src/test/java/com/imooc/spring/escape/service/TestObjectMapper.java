package com.imooc.spring.escape.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.spring.escape.use_jackson.Coupon;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestObjectMapper {

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testUseJacksonAnnotation() throws Exception {

        //  {"user":100,"assignTime":"04:38:57"}
//        Coupon coupon = Coupon.fake();
//        coupon.setTemplate(null);
//        log.info("ObjectMapper Se Coupon: {}",
//                mapper.writeValueAsString(coupon));

        // {"id":"1","userId":"100","couponCode":"123456","assignTime":"00:48:35","status":"可用的",
        // "name":"CouponTemplate","logo":"imooc"}

        String jsonCoupon = "{\"id\":\"1\",\"userId\":\"100\",\"couponCode\":\"123456\"," +
                "\"assignTime\":\"00:48:35\"," +
                "\"status\":\"USABLE\"}";
        mapper.setDateFormat(new SimpleDateFormat("HH:mm:ss"));
        log.info("{}", mapper.readValue(jsonCoupon, Coupon.class).getId());
    }
}
