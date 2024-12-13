package org.example.springbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springbook.model.BookInfo;
import org.example.springbook.model.PageRequest;
import org.example.springbook.model.PageResult;
import org.example.springbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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


    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        log.info("添加图书，bookInfo:{}", bookInfo);
        // 参数校验
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() <= 0
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return "参数错误";
        }
        // 添加图书
        try {
            bookService.insertBook(bookInfo);
        } catch (Exception e) {
            log.error("添加图书失败，e:{}",e);
            return "内部发生错误。请联系管理员";
        }
        return "加入成功呢小宝贝";
    }

    @RequestMapping("/getListByPage")
    public PageResult<BookInfo> getListByPage(PageRequest pageRequest) {
        log.info("查询列表信息，pageRequest:{}", pageRequest);
        if (pageRequest.getCurrentPage() < 1) {
            return null;
        }
        return bookService.getListByPage(pageRequest);
    }

    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId){

        log.info("查询图书信息, bookId:"+bookId);
        //参数校验
        if (bookId<1){
            log.error("非法图书ID, bookId:"+bookId);
            return null;
        }
        return bookService.queryBookById(bookId);
    }

    @RequestMapping("/updateBook")
    public boolean updateBook(BookInfo bookInfo){
        log.info("更新图书，updateBook：{}",bookInfo);
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() <= 0
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return false;
        }
        try {
            Integer result = bookService.updateBook(bookInfo);
            if (result <= 0){
                return false;
            }
            return true;
        }catch (Exception e){
            log.error("更新图书失败，e:{}",e);
            return false;
        }
    }
}
