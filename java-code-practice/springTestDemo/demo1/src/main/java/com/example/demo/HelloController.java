package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author 刘浩彬
 * @date 2023/11/21
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello,springboot!";
    }
}
