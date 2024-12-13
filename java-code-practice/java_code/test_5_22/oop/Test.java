package test_5_22.oop;

/**
 * @author 刘浩彬
 * @date 2023/5/22
 */
class Shape{
    public void draw(){
        System.out.println("画图形！");
    }
}

class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("圆");
    }
}

class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

public class Test {

    public static void drawMap(Shape shape){
        shape.draw();
    }

    //麻烦死了
    public static void drawMaps(){

        Cycle cycle = new Cycle();
        Rect rect = new Rect();
        Flower flower = new Flower();

        //多态的优点
        //减少了很多的if esle
        Shape[]shapes = {cycle,rect,cycle,rect,flower};//发生了向上转型
        for (Shape shape : shapes){
            shape.draw();
        }
        //改进一下
        /*

        Cycle cycle = new Cycle();
        Rect rect = new Rect();
        Flower flower = new Flower();

        String[]strings = {"cycle", "rect", "cycle", "rect", "flower"};
        for (String s : strings){
            if(s.equals("cycle")){
                cycle.draw();
            }else if (s.equals("rect")){
                rect.draw();
            }else {
                flower.draw();
            }
        }

         */
    }

    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        Rect rect = new Rect();
        Flower flower = new Flower();

        drawMap(cycle);
        drawMap(rect);
        drawMap(flower);

        //drawMaps();
        /**
         * 圆
         * 矩形
         * 圆
         * 矩形
         * ❀
         */

    }
}
