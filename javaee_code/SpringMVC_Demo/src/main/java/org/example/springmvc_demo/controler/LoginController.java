package org.example.springmvc_demo.controler;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 刘浩彬
 * @date 2024/1/28
 */
@RequestMapping("/login")
@RestController
public class LoginController {
    @RequestMapping("/check")
    public boolean check(String userName, String password, HttpSession session){
        // 校验账号和密码是否为空
//        if (userName == null || "".equals(userName) || password == null || "".equals(password)){
//            return false;
//        }
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        // 校验账号和密码是否正确
        // 模拟数据
        if("zhangsan".equals(userName) && "123456".equals(password)){ // 防止空指针，养成习惯 常量写在前面
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }

    @RequestMapping("/index")
    public String index(HttpSession session){ // 这里的 session = request.getSession()
        String userName = (String) session.getAttribute("userName");
        return userName;
    }
}
