package org.haobin.mybatis.model;

import lombok.Data;

import java.util.Date;

/**
 * @author 刘浩彬
 * @date 2024/2/27
 */
@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
