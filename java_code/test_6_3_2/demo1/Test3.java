package test_6_3_2.demo1;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */

/**
 * 1. 如何获取 静态内部类对象？
 * 2. 如何在静态内部类中 访问外部类的非静态的数据成员？
 *          OuterClass2 outerClass2 = new OuterClass2();
 *          System.out.println(outerClass2.data1);
 */

class  OuterClass2{
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    static class InterClass{
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;

        public void test(){
            //System.out.println(data1); -- >  报错了
            OuterClass2 outerClass2 = new OuterClass2();

            System.out.println(outerClass2.data1);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("内部类的test方法");
        }

    }

}
public class Test3 {

    public void func(){
        class Inner{
            public int data1 = 1;
        }
        Inner inner = new Inner();
        System.out.println(inner.data1);
    }

    public static void main(String[] args) {
        OuterClass2.InterClass interClass = new OuterClass2.InterClass();
        interClass.test();
    }
}
