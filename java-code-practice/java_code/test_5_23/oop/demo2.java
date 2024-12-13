package test_5_23.oop;

import java.util.Random;

/**
 * @author 刘浩彬
 * @date 2023/5/23
 */

abstract class Shape{

    /*public int a = 10;*/

    public Shape(){
        //用来让子类调用 帮助这个抽象类 初始化 自己的成员
    }
    public abstract void draw();
}

abstract class A extends Shape{
    public abstract void test();
}

class B extends A{
    @Override
    public void draw() {

    }

    @Override
    public void test() {

    }
}

class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

public class demo2 {
    public static void drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        //Shape shape = new Shape();
        Shape shape = new Rect();// 向上转型
        drawMap(new Rect());
        drawMap(new Flower());
        //new Rect() -> 匿名对象 没有名字的对象
        /*
           匿名对象的缺点是什么?
           只能用一次 每次使用都得重新实例化
         */
        Rect rect = new Rect();
        rect.draw();
        rect.draw();

        new Rect().draw();
        new Rect().draw();


    }
}
