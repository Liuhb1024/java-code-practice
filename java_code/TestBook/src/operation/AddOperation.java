package operation;

import book.Book;
import book.BookList;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class AddOperation implements IOPeration{

    public void work(BookList bookList){
        System.out.println("新增图书");
    }
}
