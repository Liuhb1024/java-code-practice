package operation;

import book.BookList;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class DelOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
    }
}
