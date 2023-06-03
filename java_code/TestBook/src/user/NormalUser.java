package user;

import operation.*;

import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 * @description：普通用户
 */
public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
        this.ioPerations = new IOPeration[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowedOperation(),
                new ReturnOperation(),
        };
    }

    public int menu(){
        System.out.println("*********************");
        System.out.println("hello! " + this.name + " 欢迎来到普通用户菜单！");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("4.退出系统");
        System.out.println("*********************");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
