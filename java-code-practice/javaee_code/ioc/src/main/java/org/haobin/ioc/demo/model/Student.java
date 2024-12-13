package org.haobin.ioc.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 刘浩彬
 * @date 2024/2/25
 */
@Component
@ConfigurationProperties(prefix = "student")
@Data
public class Student {
    private Integer id;
    private Integer age;
    private String name;
}
