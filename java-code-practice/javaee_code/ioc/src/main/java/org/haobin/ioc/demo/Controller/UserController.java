package org.haobin.ioc.demo.Controller;

import org.haobin.ioc.demo.Service.UserService;
import org.haobin.ioc.demo.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 刘浩彬
 * @date 2024/2/18
 */
@Controller
public class UserController {
    // 把 UserService 注入进来
//    @Autowired
//    private UserService userService;

    /**
     * 以下为 构造函数注入 示例
     */
//    private UserService userService;
//    private UserConfig userConfig;
//
//    public UserController(){
//
//    }
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Autowired
//    public UserController(UserService userService, UserConfig userConfig) {
//        this.userService = userService;
//        this.userConfig = userConfig;
//    }

    /**
     * 以下为 setter 方法注入示例
     */
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void sayHi(){
        System.out.println("hello, UserController...");
        userService.syaHi();
    }
}
