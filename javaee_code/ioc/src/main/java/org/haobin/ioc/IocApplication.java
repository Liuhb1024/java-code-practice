package org.haobin.ioc;

import org.haobin.ioc.demo.Controller.UserController;
import org.haobin.ioc.demo.Controller.UserController2;
import org.haobin.ioc.demo.Service.UserService;
import org.haobin.ioc.demo.component.UserComponent;
import org.haobin.ioc.demo.config.UserConfig;
import org.haobin.ioc.demo.model.UserInfo;
import org.haobin.ioc.demo.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocApplication {
    public static void main(String[] args) {
        // ApplicationContext : Spring 上下文、运行环境
        ApplicationContext context = SpringApplication.run(IocApplication.class, args);
//        UserController bean = context.getBean(UserController.class);
//        bean.sayHi();

        UserController2 bean2 = context.getBean(UserController2.class);
        bean2.sayHi();

        UserService userService = (UserService) context.getBean("userService");
        userService.syaHi();

        UserComponent userComponent = context.getBean("userComponent", UserComponent.class);
        userComponent.sayHi();

        UserRepository userRepository = (UserRepository) context.getBean("userRepository");
        userRepository.sayHi();

        UserConfig userConfig = context.getBean(UserConfig.class);
        userConfig.sayHi();

        UserInfo userInfo = context.getBean("u1",UserInfo.class);
        System.out.println(userInfo);

        UserInfo userInfo1 = context.getBean("userInfo1",UserInfo.class);
        System.out.println(userInfo1);

        System.out.println("==================================================");


    }
}

