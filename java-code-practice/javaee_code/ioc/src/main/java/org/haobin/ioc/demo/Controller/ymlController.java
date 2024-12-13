package org.haobin.ioc.demo.Controller;

import org.haobin.ioc.demo.model.Dbtypes;
import org.haobin.ioc.demo.model.Maptypes;
import org.haobin.ioc.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yml")
public class ymlController {
    @Value("${string.value}")
    private String value;

    @Value("${string.value2}")
    private String key2;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${string.str1}")
    private String str1;

    @Value("${string.str2}")
    private String str2;

    @Value("${string.str3}")
    private String str3;

    @RequestMapping("/readValue")
    public String readValue() {
        return "从yml读取配置文件，value：" + value;
    }

    @RequestMapping("/readValue2")
    public String readValue2() {
        return "从yml读取配置文件，key2：" + key2;
    }

    @RequestMapping("/url")
    public String readUrl() {
        return "从yml读取配置文件，url：" + url;
    }


    @RequestMapping("/yml")
    public String readYml() {
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        return "yml";
    }

    @Autowired
    private Student student;

    @RequestMapping("/stu")
    public String readStu(){
        return student.toString();
    }

    @Autowired
    private Dbtypes dbtypes;

    @RequestMapping("/list")
    public String readList(){
        return dbtypes.toString();
    }

    @Autowired
    private Maptypes maptypes;

    @RequestMapping("/map")
    public String readMap(){
        return maptypes.toString();
    }

}
