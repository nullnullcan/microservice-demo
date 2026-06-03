package com.demo.service.impl;

import com.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(Long id) {
        return "我是用户：" + id;
    }
}