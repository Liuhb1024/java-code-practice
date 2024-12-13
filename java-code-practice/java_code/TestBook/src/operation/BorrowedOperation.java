package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class BorrowedOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：> ");
        String name = scanner.nextLine();

        int currentSize = bookList.getUsedSize();

        //如果有一本书，就不能添加了
        for (int i = 0; i < currentSize; i++) {
            Book book1 = bookList.getBook(i);
            if (book1.getName().equals(name)){
                if (!book1.isBorrowed()){
                    book1.setBorrowed(true);
                    System.out.println("借阅成功");
                }else{
                    System.out.println("这本书已经被借走了");
                }
                return;
            }
        }
        System.out.println("没有你要借阅这本书！");
    }
}
