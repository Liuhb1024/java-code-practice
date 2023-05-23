package test_5_23.oop.demo3;

/**
 * @author 刘浩彬
 * @date 2023/5/23
 */

interface IShape{
    //public static final int a = 10;
    int a = 10;
    //public abstract void draw();
    void draw();

    /*public void test(){

    }*/
    //改进：
    default public void test(){
        System.out.println("test();");
    }

    public static void test2(){
        System.out.println("static ");
    }

}

class Rect implements IShape{
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class Flower implements IShape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

public class TestDemo {
    public static void drawMap(IShape iShape){
        iShape.draw();
    }
    public static void main(String[] args) {
        //IShape iShape = new IShape();
        IShape iShape1 = new Rect();
        IShape iShape2 = new Flower();

        drawMap(new Rect());
        drawMap(new Flower());

    }
}
