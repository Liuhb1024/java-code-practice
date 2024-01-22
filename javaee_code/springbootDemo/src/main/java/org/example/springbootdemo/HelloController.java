package org.example.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘浩彬
 * @date 2024/1/22
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello, SpringBoot";
    }

    @RequestMapping("/helloCN")
    public String helloCN(){
        return "hello, SpringBoot 中国";
    }
}

