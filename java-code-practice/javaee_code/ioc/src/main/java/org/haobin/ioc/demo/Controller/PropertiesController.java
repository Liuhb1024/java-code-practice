package org.haobin.ioc.demo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘浩彬
 * @date 2024/2/25
 */

@RestController
@RequestMapping("/prop")
public class PropertiesController {
    @Value("${ben.key1}")
    private String key1;

    @Value("${ben.key2}")
    private Integer key2;

    @RequestMapping("/readValue")
    public String readValue(){
        return "从Properties读取配置文件，key1："+key1;
    }

    @RequestMapping("/readValue2")
    public String readValue2(){
        return "从Properties读取配置文件，key2："+key2;
    }
}





























