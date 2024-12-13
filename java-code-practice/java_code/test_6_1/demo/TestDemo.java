package test_6_1.demo;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */
// 接口

interface IShape{
    public static final int a = 10;
    public abstract void draw();

    /*public void test(){

    }*/

    default public void test(){
        System.out.println("test() ");
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

class Flowers implements IShape{
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
        /*IShape iShape = new IShape();*/

        //1
        drawMap(new Rect());
        drawMap(new Flowers());

        //2
        IShape iShape1 = new Rect();
        IShape iShape2 = new Flowers();

        drawMap(iShape1);
        drawMap(iShape2);


    }


}
