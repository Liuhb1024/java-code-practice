package test_6_3.demo5;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */

//内部类 外部类

class OuterClass{

    //一个类一个字节码文件
    class InterClass{
        //实力内部类
    }

    static class InterClass2{
        //静态内部类
    }


}


interface A{
    void testA();
}

public class Test {
    public static void main(String[] args) {
        //以下代码可以认为：有一个类实现了A接口，并且重写了A接口中的方法
        A a = new A(){
            @Override
            public void testA() {
                System.out.println("哈哈哈！");
            }
        };//匿名内部类 这个类没有名字
        a.testA();
    }
}
