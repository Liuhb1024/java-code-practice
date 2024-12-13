package org.example.springmvc_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘浩彬
 * @date 2024/1/27
 */

@RequestMapping("/return")
//@RestController
@Controller
// 多个注解的时候 注解不分先后顺序
public class ReturnController {
    @RequestMapping("/r1")
    public String r1(){
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/r2")
    public String r2(){
        return "hello spring";
    }

    @ResponseBody
    @RequestMapping("/r3")
    public String r3(){
        return "<h1>我是返回的片段</h1>";
    }

    @ResponseBody
    @RequestMapping("/r4")
    public UserInfo r4(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("zhangsan");
        userInfo.setAge(19);
        return userInfo;
    }

    @ResponseBody
    @RequestMapping("/r5")
    public Map<String ,String> r5(){
        HashMap map = new HashMap();
        map.put("k1","v1");
        map.put("k2","v2");
        return map;
    }

//    @ResponseBody
    @RequestMapping("/r6")
    public String r6(){
        return "/a.js";
    }

    @RequestMapping("/r7")
    public String r7(){
        return "/b.css";
    }

    @ResponseBody
    @RequestMapping("/r8")
    public String r8(HttpServletResponse response){
        response.setStatus(401);
        return "设置状态码成功";
    }

    @ResponseBody
    @RequestMapping(value = "/r9",produces = "application/json")
    public String r9(){
        return "123333";
    }

    @ResponseBody
    @RequestMapping(value = "/r10",produces = "application/json")
    public String r10(HttpServletResponse response){
        response.setHeader("myHeader","myHeaderValue");
        return "设置Header成功";
    }
}
