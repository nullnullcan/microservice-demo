package com.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.service.UserService;

@FeignClient(name = "user-service")
public interface UserFeignClient extends UserService {

    @GetMapping("/user/get")
    String getUser(@RequestParam Long id);
}