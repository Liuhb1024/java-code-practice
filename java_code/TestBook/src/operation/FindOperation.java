package operation;

import book.BookList;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class FindOperation implements IOPeration{
    public void work(BookList bookList){
        System.out.println("查找图书");
    }
}
