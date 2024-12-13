package org.haobin.ioc.demo.component;

import org.springframework.stereotype.Component;

/**
 * @author 刘浩彬
 * @date 2024/2/18
 */
@Component
public class UserComponent {
    public void sayHi(){
        System.out.println("hello,UserComponent...");
    }
}
