package org.example.springbook.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 刘浩彬
 * @date 2024/2/8
 */
@Data
public class BookInfo {
    /**
     * 图书 id
     */
    private Integer id;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 出版社
     */
    private String publish;

    /**
     * 书本状态
     * 1- 可借阅
     * 2- 不可借阅
     */
    private Integer status;

    /**
     * 书本状态转化
     */
    private String stateCN;

    private Date createTime;
    private Date updateTime;
}
