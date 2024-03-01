package org.example.springbook.model;

import lombok.Data;

import java.util.Date;

/**
 * @author 刘浩彬
 * @date 2024/3/1
 */
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Integer delete_flag;
    private Date createTime;
    private Date updateTime;

}
