package org.example.springbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springbook.model.BookInfo;
import org.example.springbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 刘浩彬
 * @date 2024/2/8
 */
//@RestController
@Slf4j
@ResponseBody
@Component
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        // 1. 从数据库中获取数据
        // 数据采用 Mock 的方式
        List<BookInfo> bookInfos = bookService.getBookInfoList();
        // 2. 对数据进行处理：状态转化
        // 3. 返回数据
        return bookInfos;
    }

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        log.info("添加图书，bookInfo:{}", bookInfo);
        // 参数校验
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() <= 0
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() ==null)
        {
            return "参数错误";
        }
        // 添加图书
        try {
            bookService.insertBook(bookInfo);
        } catch (Exception e) {
            return "内部发生错误。请联系管理员";
        }
        return "加入成功呢小宝贝";
    }


}
