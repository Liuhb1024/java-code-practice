package operation;

import book.Book;
import book.BookList;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class ShowOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            //Book book = bookList[i];
            System.out.println(book);
        }
    }
}
