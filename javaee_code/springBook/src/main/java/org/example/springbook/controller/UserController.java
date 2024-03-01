package org.example.springbook.controller;

import org.example.springbook.model.UserInfo;
import org.example.springbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 刘浩彬
 * @date 2024/2/8
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session) {
        // 校验参数
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }
        // 判断数据库的密码和用户输入的密码是否一致
        // 查询数据库 拿到数据库的密码
        UserInfo useInfo = userService.queryByName(userName);
        if (useInfo==null){
            return false;
        }
        if (password.equals(useInfo.getPassword())){
            useInfo.setPassword("");
            // 密码正确 存 session
            session.setAttribute("user_session",useInfo);
            return true;
        }
        return false;
    }
}
