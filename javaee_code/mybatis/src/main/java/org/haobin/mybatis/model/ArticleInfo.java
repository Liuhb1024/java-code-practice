package org.haobin.mybatis.model;

import lombok.Data;

import java.util.Date;

/**
 * @author 刘浩彬
 * @date 2024/2/28
 */
@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deletFlag;
    private Date createTime;
    private Date updateTime;

    // 用户信息
    private String username;
    private Integer age;
    private Integer gender;
}
