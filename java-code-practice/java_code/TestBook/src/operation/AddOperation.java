package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class AddOperation implements IOPeration{

    public void work(BookList bookList){
        System.out.println("新增图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：> ");
        String name = scanner.nextLine();

        System.out.println("请输入作者：> ");
        String author = scanner.nextLine();

        System.out.println("请输入价格：> ");
        int price = scanner.nextInt();

        //nextInt --> type 会把回车读成我的类型 所以这个时候应该如下

        scanner.nextLine();
        System.out.println("请输入类型：> ");
        String type = scanner.nextLine();

        Book book = new Book(name,author,price,type);

        int currentSize = bookList.getUsedSize();

        //如果有一本书，就不能添加了
        for (int i = 0; i < currentSize; i++) {
            Book book1 = bookList.getBook(i);
            if (book1.getName().equals(name)){
                System.out.println("书架存在这本书，不能添加！");
                return;
            }
        }

        //默认是放到了 数组最后的位置
        bookList.setBooks(currentSize,book);

        //让useSize++
        bookList.setUsedSize(currentSize + 1);

    }
}
