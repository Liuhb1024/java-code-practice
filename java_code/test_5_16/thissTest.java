package test_5_16;

import java.util.Date;

public class thissTest {
    public int year;
    public int month;
    public int day;
/*
    public void setDate(int y, int m, int d){
        year = y;
        month = m;
        day = d;
    }
    输出：年：2008月：9日：9
*/

    /*
//---------------------------------------------------------------
    public void setDate(int year, int month, int day){
        year = year;
        month = month;
        day = day;
    }
    //输出年：0月：0日：0
    //就近原则
*/

    //修改方法
    //代表当前对象的引用，建议习惯使用this
    //谁调用当前的setDate方法，谁就是this
    public void setDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void printDate(){
        System.out.println("年："+year+"月："+month+"日："+day);
    }

    public static void main(String[] args) {
        thissTest date = new thissTest();
        date.setDate(2008,9,9);
        date.printDate();
        System.out.println("--------------------");
        thissTest date2 = new thissTest();
//setDate方法里面的this，就是谁调用过了这个方法
        date2.setDate(2999,9,9);
        date2.printDate();

        /*
        通过this可以访问当前对象的成员属性/成员变量【静态成员变量不支持】
         */
    }
}
