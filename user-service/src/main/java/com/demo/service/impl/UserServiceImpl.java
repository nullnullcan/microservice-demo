package com.demo.service.impl;

import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DubboService   // 同时暴露为 Dubbo 服务
public class UserServiceImpl implements UserService {
    @Override
    public String getUserList(Long id) {
        return "用户ID：" + id;
    }
}