package test_6_3_2.demo1;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */

//匿名内部类

interface A{
    void test();
}

public class Test {
    public static void main(String[] args) {
        int val = 10;
        //val = 100;
        new A(){
            @Override
            public void test() {
                //默认在这里能访问的是 被final修饰的

                System.out.println("值：" + val);//在匿名内部类中 能够访问的是 没有被修改过的数据-->变量的捕获
            }
        }.test();

        System.out.println(val);
    }
}
