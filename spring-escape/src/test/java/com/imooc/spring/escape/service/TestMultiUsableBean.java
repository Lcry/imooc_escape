package com.imooc.spring.escape.service;

import com.imooc.spring.escape.multi_usable_bean.ITemplateManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMultiUsableBean {

//    @Autowired
//    @Qualifier("qinyiRedisTemplate")
//    @Resource
//    private RedisTemplate redisTemplate;
    @Autowired
    @Qualifier("qinyiRedisTemplate")
    private RedisTemplate imoocRedisTemplate;

    @Autowired
    @Qualifier("qinyiTemplateManagerService")
    private ITemplateManagerService templateManagerService;

    @Test
    public void testAutowire() {

        assert imoocRedisTemplate != null;
        imoocRedisTemplate.getConnectionFactory().getConnection().flushAll();

        imoocRedisTemplate.opsForValue().set("name", "qinyi");
    }

    @Test
    public void testTemplateManagerService() {

//        assert templateManagerService == null;

        templateManagerService.print();
    }

    @Test
    public void testUseRedisPipeline() {

        // 清空 Redis 服务器中的数据, 方便校验测试
        imoocRedisTemplate.getConnectionFactory().getConnection().flushAll();

        List<Object> resultList = imoocRedisTemplate.executePipelined(
                new RedisCallback<Object>() {
                    @Override
                    public Object doInRedis(RedisConnection connection)
                            throws DataAccessException {

                        // 1. 通过 connection 打开 pipeline
                        connection.openPipeline();

                        // 2. 给本次 pipeline 添加一次性要执行的多条命令
                        // 2.1 一个 set key value 的操作
                        byte[] key = "name".getBytes();
                        byte[] value = "qinyi".getBytes();
                        connection.set(key, value);

                        // 2.2 执行一个错误的命令
                        connection.lPop("xyzabc".getBytes());

                        // 2.3 mset 操作
                        Map<byte[], byte[]> tuple = new HashMap<>();
                        tuple.put("id".getBytes(), "1".getBytes());
                        tuple.put("age".getBytes(), "19".getBytes());
                        connection.mSet(tuple);

                        // 3. 关闭 pipeline
//                        connection.closePipeline();

                        return null;
                    }
                }
        );

        resultList.forEach(System.out::println);
    }
}
