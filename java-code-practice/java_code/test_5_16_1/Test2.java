package test_5_16_1;
/*
import java.util.Arrays;
import java.util.Date;
 */

//通配符
import java.util.*;


/*
package java.util
声明当前Java文件是在哪个包底下
 */

public class Test2 {
    public static void main(String[] args) {
        int[]array = {1,2,3,4};
        System.out.println(Arrays.toString(array));
        Date data = new Date();

        double x = 30;
        double y = 40;
        //静态导入的方式写起来更方便一些
        double result = Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
        //double result = sqrt(pow(x,2)+pow(y,2));
        System.out.println(result);
    }
}
/*
封装：
1.什么是封装？
     对象的成员 进行隐藏 通过关键字private 只是对类外提供公开的接口
2.封装的意义是什么？
     可以隐藏类的实现细节 从而达到安全性
 */