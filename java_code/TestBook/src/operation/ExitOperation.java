package operation;

import book.BookList;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class ExitOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
    }
}
