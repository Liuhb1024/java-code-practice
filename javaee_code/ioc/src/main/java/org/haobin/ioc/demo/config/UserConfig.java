package org.haobin.ioc.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 刘浩彬
 * @date 2024/2/21
 */
@Configuration
public class UserConfig {
    public void sayHi(){
        System.out.println("hello,userConfig");
    }
}
