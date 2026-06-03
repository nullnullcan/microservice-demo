package com.demo.controller;

import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/demo")
public class DemoController {

    // 1. 为本地服务Bean指定名称 "userServiceImpl"
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService localUserService;

    // 2. 为Feign远程服务Bean指定名称，这个Bean的名称通常就是FeignClient接口名小写 "userFeignClient"
//    @Autowired
//    @Qualifier("userFeignClient")
//    private UserFeignClient userFeignClient;

    @GetMapping("/test")
    public String getList() {
        // 单体模式 (mvc) 下，注入的是 localUserService
        // 微服务模式 (cloud) 下，注入的是 userFeignClient
      
        return localUserService.getUserList();
    }
}