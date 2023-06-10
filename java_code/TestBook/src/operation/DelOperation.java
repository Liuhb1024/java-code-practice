package operation;

import book.Book;
import book.BookList;
import com.sun.xml.internal.ws.api.server.SDDocument;

import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class DelOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");

        //1. 找到你要删除的书
        int currentSize = bookList.getUsedSize();
        if (currentSize == 0){
            System.out.println("书架为空，不能删除！");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：> ");
        String name = scanner.nextLine();



        int index = -1;
        //如果有一本书，就不能添加了
        for (int i = 0; i < currentSize; i++) {
            Book book1 = bookList.getBook(i);
            if (book1.getName().equals(name)){
                index = i;
                break;
            }
        }
        // 2. index != -1 有这本书 开始删除
        if (index == -1){
            System.out.println("没有你要删除的书！");
            return;
        }

        for (int i = index; i < currentSize - 1; i++) {
            Book book1 = bookList.getBook(i + 1);
            bookList.setBooks(i,book1);
        }

        //当书删掉之后 需要维持usedSize
        bookList.setUsedSize(currentSize - 1);
    }
}
