package org.haobin.ioc.demo.model;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘浩彬
 * @date 2024/2/21
 */
@Data
public class UserInfo {
    private Integer id;
    private String name;
    private Integer age;
}
