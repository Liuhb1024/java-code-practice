package org.example.springbook.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.springbook.model.BookInfo;

/**
 * @author 刘浩彬
 * @date 2024/3/1
 */
@Mapper
public interface BookInfoMapper {
    @Insert("insert into book_info(book_name, author, count, price,publish,status)" +
            "values (#{bookName}, #{author}, #{count}, #{price}, #{publish},#{status})")
    Integer insertBook(BookInfo bookInfo);
}
