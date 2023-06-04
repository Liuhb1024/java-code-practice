import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */
public class Main {

    //登录
    //可以利用返回值 的向上转型 达到发挥的一致性 ：> User
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的姓名：>");
        String name = scanner.nextLine();
        System.out.println("请输入您的身份：> 1 -> 管理员  0 -> 普通用户");
        int choice = scanner.nextInt();
        if (choice == 1) {
            /*AdminUser adminUser = new AdminUser(name);
            return adminUser;*/
            return new AdminUser(name);
        } else if (choice == 0) {
            /*NormalUser normalUser = new NormalUser(name);
            return normalUser;*/
            return new NormalUser(name);
        } else {
            System.out.println("您的输入有错误，请重新输入！");
            return login();
        }
    }

    public static void main(String[] args) {

        BookList bookList = new BookList();

        User user = login();
        while (true){
            int choice = user.menu();


        //int choice = user.menu();// --->  父类变成抽象类
        //user是哪个对象? choice是几？ ---->  能够确定：我能够操作哪个对象的哪个方法
        //通过这两个变量 可以确定了 但是怎么联系起来 ？？

        /**
         * 建立联系
         * 1. 先让双方 存好 对应自己的操作
         * 2.就是调用对应的操作
         */
            user.doOperation(choice,bookList);
        /*System.out.println(choice);
        System.out.println(user);
         */
        }
    }
}
