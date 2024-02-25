package org.haobin.ioc.demo.config;

import org.haobin.ioc.demo.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jws.soap.SOAPBinding;

/**
 * @author 刘浩彬
 * @date 2024/2/21
 */
@Configuration
public class BeanConfig {

    @Bean("u1")
    public UserInfo userInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(5);
        userInfo.setName("zhangsan");
        userInfo.setAge(18);
        return userInfo;
    }

    @Bean
    public UserInfo userInfo1(){
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(6);
        userInfo1.setName("6666");
        userInfo1.setAge(66);
        return userInfo1;
    }
}
