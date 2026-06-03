package com.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-service", path = "/internal")
public interface UserFeignClient {
    @GetMapping("/users")
    String getUserList();
}