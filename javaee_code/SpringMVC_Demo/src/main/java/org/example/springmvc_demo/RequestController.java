package org.example.springmvc_demo;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author 刘浩彬
 * @date 2024/1/27
 */
@RestController
@RequestMapping("/request")
public class RequestController {
    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest request) // 内置对象，有需要就加上，没需要就不加 需要几个就加几个
    {
        Cookie[] cookies = request.getCookies();

//        Arrays.stream(cookies).forEach(x->{
//            System.out.println(x.getName()+":"+x.getValue());
//        });

        // 等价于
        if (cookies != null){
        for(Cookie c:cookies){
            System.out.println(c.getName()+":"+c.getValue());
        }
        return "获取Cookies成功";
        }
        else
            return "获取Cookies不成功";
    }

    @RequestMapping("/getCookie2")
    public String getCookie2(@CookieValue ("riyewuxiushi")String riyewuxiushi){
        return "riyewuxiushi"+riyewuxiushi;
    }

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userName","zhangsan");
        return "设置session成功";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        return "登录用户:"+ userName;
    }

    @RequestMapping("/getSession2")
    public String getSession2(HttpSession session){
        String userName = (String) session.getAttribute("userName");
        return "登录用户:"+ userName;
    }

    @RequestMapping("/getSession3")
    public String getSession3(@SessionAttribute(value = "userName",required = false) String userName){
        return "登录用户:"+ userName;
    }

    @RequestMapping("/getheader")
    public String getheader(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return "userAgent"+userAgent;
    }

    @RequestMapping("/getheader2")
    public String getheader2(@RequestHeader("User-Agent")String userAgent){
        return "userAgent"+userAgent;
    }
}
