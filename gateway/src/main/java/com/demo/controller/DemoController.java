package com.demo.controller;

import com.demo.client.UserFeignClient;
import com.demo.dubbo.UserDubboConsumer;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    // 单体模式：直接注入本地 Service
    @Autowired(required = false)
    private UserService localUserService;

    // Cloud 模式：Feign 远程调用
    @Autowired(required = false)
    private UserFeignClient userFeignClient;

    // Dubbo 模式：通过包装类调用
    @Autowired(required = false)
    private UserDubboConsumer userDubboConsumer;

    @GetMapping("/list")
    public List<String> getList() {
        // 根据 profile 决定使用哪种方式
        String active = System.getProperty("spring.profiles.active", "mvc");
        if ("cloud".equals(active) && userFeignClient != null) {
            return userFeignClient.getUserList();
        } else if ("dubbo".equals(active) && userDubboConsumer != null) {
            return userDubboConsumer.getUserList();
        } else {
            // 默认单体模式
            return localUserService.getUserList();
        }
    }
}