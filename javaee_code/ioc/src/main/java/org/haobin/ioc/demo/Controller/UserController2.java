package org.haobin.ioc.demo.Controller;

import org.haobin.ioc.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author 刘浩彬
 * @date 2024/2/22
 */
@Controller
public class UserController2 {
    @Autowired
    private UserInfo u1;
    public void sayHi(){
        System.out.println("hello, UserController...");
        System.out.println(u1);
    }
}
