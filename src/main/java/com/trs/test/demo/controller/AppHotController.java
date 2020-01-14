package com.trs.test.demo.controller;

import com.alibaba.fastjson.JSON;
import com.trs.test.demo.entity.User;
import com.trs.test.demo.redis.RedisUtils;
import com.trs.test.demo.service.AppHotService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RestController
@MapperScan("com.trs.test.demo.mapper")
public class AppHotController {

    private static Logger log = Logger.getLogger(AppHotController.class.getName());

    @Autowired
    private AppHotService appHotService;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/select")
    public String getAppHotById(@RequestParam int id){

//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        jedis.set("name","xiexiong");
//        jedis.get("name");

        redisUtils.set("age",18,30000L,TimeUnit.MILLISECONDS);//毫秒级
        String token = "";
        if(redisUtils.exists("age")){
            log.info("=============从redis缓存获取数据===============》");
            token = String.valueOf(redisUtils.get("token"));
        }else {
            log.info("===============从数据库获取数据================》");
        }

        User user = appHotService.selectAppHotById(id);
        String jsonStr = JSON.toJSONString(user)+token;
        log.info("log4j已生效");
        return jsonStr;
    }
}
