package com.demo.feign;

import com.demo.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserFeignClient extends UserService {

    @Override
    @GetMapping("/user/get")
    String getUser(@RequestParam Long id);
}