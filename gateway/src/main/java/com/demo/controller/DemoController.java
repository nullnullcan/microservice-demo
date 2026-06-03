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
    private UserService localUserService;

    @Autowired(required = false)
    private UserFeignClient userFeignClient;

    @Autowired(required = false)
    private UserDubboConsumer userDubboConsumer;

    @GetMapping("/list")
    public String getList() {
        if (userFeignClient != null) {
            return userFeignClient.getUserList();
        } else if (userDubboConsumer != null) {
            return userDubboConsumer.getUserList();
        } else {
            return localUserService.getUserList();
        }
    }
}