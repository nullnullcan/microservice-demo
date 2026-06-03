package com.demo.service;

import java.util.List;

public interface UserService {
    String getUserList(Long id);
    // 加上这个方法！！！
    default String getUserList() {
        return "user list";
    }
}