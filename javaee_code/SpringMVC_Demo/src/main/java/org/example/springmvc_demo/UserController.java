package org.example.springmvc_demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/1/22
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello()
    {
        return "hello";
    }

    @RequestMapping("/r1")
    public String r1(String name){
        return "接受到参数 name:" + name;
    }

    @RequestMapping("/r2")
    public String r2(int age){
        return "接受到参数 age:" + age;
    }
    @RequestMapping("/r3")
    public String r3(String name,Integer age){
        return "name:"+name+" "+"age:"+age;
        // 参数请求 顺序先后不分
    }

    @RequestMapping("/r4")
    public String r4(UserInfo user){
        return user.toString();
    }

    @RequestMapping("/r5")
    public String r4(@RequestParam("name") String username, Integer age){
        return "username: " + username+ ", age: " + age;
    }

    @RequestMapping("/r6")
    public String r6(@RequestParam(value = "name", required = false) String username, Integer age){
        return "username: " + username+ ", age: " + age;
    }

    @RequestMapping("/r7")
    public String r7(String[]arr){
        return Arrays.toString(arr);
    }

    @RequestMapping("/r8")
    public String r8(@RequestParam("list") List<String> list){
        return list.toString();
    }

    @RequestMapping("/r9")
    public String r9(@RequestBody UserInfo userInfo){
        return userInfo.toString();
    }

    @RequestMapping("/r10/{articleId}")
    public String r10(@PathVariable Integer articleId){
        return "articleId:"+articleId;
    }

    @RequestMapping("/r11")
    public String r11(@RequestPart MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        file.transferTo(new File("D:/temp/"+fileName));
        return "获取上传文件：" + file.getOriginalFilename();
    }
}


