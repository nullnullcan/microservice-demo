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

    @Autowired(required = false)
    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mvc", matchIfMissing = true)
    private UserService localUserService;

    @Autowired(required = false)
    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "cloud")
    private UserFeignClient userFeignClient;

    @Autowired(required = false)
    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "dubbo")
    private UserDubboConsumer userDubboConsumer;

    @GetMapping("/list")
    public List<String> getList() {
        if (userFeignClient != null) {
            return userFeignClient.getUserList();
        } else if (userDubboConsumer != null) {
            return userDubboConsumer.getUserList();
        } else {
            return localUserService.getUserList();
        }
    }
}