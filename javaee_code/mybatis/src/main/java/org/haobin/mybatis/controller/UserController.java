package org.haobin.mybatis.controller;

import org.haobin.mybatis.model.UserInfo;
import org.haobin.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/2/27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryAllUser")
    public List<UserInfo> queryAllUser() {
        return userService.queryAllUser();
    }

    /**
     * 模拟 sql 注入 完成用户登录
     */
    @RequestMapping("/login")
    public UserInfo login(String userName, String password) {
        // 1. 根据用户名和密码去查询
        return userService.queryUserByNameAndPassword(userName, password) ;
    }

}
