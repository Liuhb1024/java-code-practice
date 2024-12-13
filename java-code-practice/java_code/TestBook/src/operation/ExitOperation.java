package operation;

import book.Book;
import book.BookList;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class ExitOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");

        int currentSize = bookList.getUsedSize();

        for (int i = 0; i < currentSize; i++) {
            bookList.setBooks(i,null);
        }
        bookList.setUsedSize(0);

        System.exit(0);
    }
}
