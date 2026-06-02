package com.demo.dubbo;

import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDubboConsumer {
    @DubboReference
    private UserService userService;

    public List<String> getUserList() {
        return userService.getUserList();
    }
}