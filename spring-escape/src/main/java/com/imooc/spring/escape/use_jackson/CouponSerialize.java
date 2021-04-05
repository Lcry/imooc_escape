package com.imooc.spring.escape.use_jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CouponSerialize extends JsonSerializer<Coupon> {

    @Override
    public void serialize(Coupon coupon, JsonGenerator generator,
                          SerializerProvider serializers) throws IOException {

        // 开始序列化
        generator.writeStartObject();

        generator.writeStringField("id", String.valueOf(coupon.getId()));
        generator.writeStringField("userId", coupon.getUserId().toString());
        generator.writeStringField("couponCode", coupon.getCouponCode());
        generator.writeStringField("assignTime",
                new SimpleDateFormat("HH:mm:ss").format(coupon.getAssignTime()));
        generator.writeStringField("status", coupon.getStatus().getDesc());

        generator.writeStringField("name", coupon.getTemplate().getName());
        generator.writeStringField("logo", coupon.getTemplate().getLogo());

        // 结束序列化
        generator.writeEndObject();
    }
}
