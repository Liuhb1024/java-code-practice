package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class FindOperation implements IOPeration{
    public void work(BookList bookList){
        System.out.println("查找图书");


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的图书：> ");
        String name = scanner.nextLine();

        int currentSize = bookList.getUsedSize();

        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)){
                System.out.println("找到了你要查找的书：> ");
                System.out.println(book);
                return;
            }
        }
        System.out.println("不好意思，你好像没有这本书！");
    }
}
