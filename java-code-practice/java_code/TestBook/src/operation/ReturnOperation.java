package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class ReturnOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：> ");
        String name = scanner.nextLine();

        int currentSize = bookList.getUsedSize();

        //如果有一本书，就不能添加了
        for (int i = 0; i < currentSize; i++) {
            Book book1 = bookList.getBook(i);
                if (book1.getName().equals(name)){
                    book1.setBorrowed(false);
                    return;
                }
        }
        System.out.println("没有你要归还的这本书！");
    }

}

