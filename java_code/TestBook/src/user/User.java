package user;

import book.BookList;
import operation.IOPeration;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public abstract class User {
    protected String name;//姓名

    public IOPeration[] ioPerations;//只是定义 没有初始化大小

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    //建立联系
    public void doOperation(int choice, BookList bookList){
        ioPerations[choice].work(bookList);
    }
}
