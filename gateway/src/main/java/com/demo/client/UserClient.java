package com.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 直接调用 user-service 服务，不用引对方包
@FeignClient(name = "user-service")
public interface UserClient {

    // 写和对方一样的接口路径
    @GetMapping("/user/{id}")
    String getUser(@PathVariable("id") Long id);
}