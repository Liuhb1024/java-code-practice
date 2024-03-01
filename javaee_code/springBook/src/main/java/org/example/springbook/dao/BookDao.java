package org.example.springbook.dao;

import org.example.springbook.model.BookInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 刘浩彬
 * @date 2024/2/12
 */
@Repository
public class BookDao {

    public List<BookInfo> mockBookData() {
        List<BookInfo> bookInfos = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setCount(i);
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社" + i);
            bookInfo.setStatus(i % 5 == 0 ? 2 : 1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }

}
