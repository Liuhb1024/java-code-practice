package org.haobin.ioc.demo.repo;

import org.springframework.stereotype.Repository;

/**
 * @author 刘浩彬
 * @date 2024/2/18
 */
@Repository
public class UserRepository {
    public void sayHi(){
        System.out.println("hello, userRepository");
    }
}
