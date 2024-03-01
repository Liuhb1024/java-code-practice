package org.example.springbook.service;

import org.example.springbook.dao.BookDao;
import org.example.springbook.mapper.BookInfoMapper;
import org.example.springbook.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/2/12
 */

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    /**
     * 根据数据层返回的结果，对数据进行处理
     * @return
     */
    public List<BookInfo> getBookInfoList(){
        List<BookInfo> bookInfos = bookDao.mockBookData();
        // 2. 对数据进行处理：状态转化
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStateCN("可借阅");
            } else if (bookInfo.getStatus() == 2) {
                bookInfo.setStateCN("不可借阅");
            }
        }
        return bookInfos;
    }

    public Integer insertBook(BookInfo bookInfo){
        return bookInfoMapper.insertBook(bookInfo);
    }
}
