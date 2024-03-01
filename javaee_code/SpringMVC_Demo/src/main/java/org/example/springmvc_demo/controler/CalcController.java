package org.example.springmvc_demo.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘浩彬
 * @date 2024/1/28
 */
@RestController
@RequestMapping("/calc")
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2){
        Integer sum  = num1 + num2;
        return "<h1>计算机计算结果: "+sum+"</h1>";
    }
}
