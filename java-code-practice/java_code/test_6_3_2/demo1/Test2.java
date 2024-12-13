package test_6_3_2.demo1;

/**
 * @author 刘浩彬
 * @date 2023/6/3
 */

//实例内部类

class OuterClass{
    //
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    /**
     * 注意点：
     *
     * 1. 如何获取 实例内部类对象？
     * 2. 在实例内部类中，是否可以定义静态的成员变量？
     *            public static final int data6 = 6; --> 这样子是可以的
     *            类加载的时候不会加载普通的成员变量 ， 实例内部类中又存在static，而static是在类加载的时候创建的
     * 3.当外部类中的数据成员 和 内部类中的数据成员 一样的时候 可以使用 OuterClass.this.去访问
     *            实例内部类中 是包含 外部类的this的
     *
     */


    class InterClass{

        public int data1 = 11111;

        public int data4 = 4;
        private int data5 = 5;

        //public static int data6 = 6; ----> 报错了 ， static代表是不依赖任何对象，但是他又依赖于外部类对象
        public static final int data6 = 6;
        //final 修饰的是常量

        public void test(){
            System.out.println(data1);
            /**
             * 输出：
             * 11111
             * 4
             * 5
             * 内部类的test方法
             */
            System.out.println(this.data1);
            //还是1111
            System.out.println(OuterClass.this.data1);
            //输出 1 了

            System.out.println(data4);
            System.out.println(data5);
            System.out.println("内部类的test方法");
        }
    }

    public void test(){
        System.out.println("外部类的test方法");
        InterClass interClass = new InterClass();
        System.out.println(interClass.data4);
    }
}
public class Test2 {
    public static void main(String[] args) {
        //InterClass interClass = new InterClass(); ----------> 报错了！
        OuterClass outerClass = new OuterClass();
        //System.out.println(outerClass.data1);

        //获取实例内部类对象的时候 依赖于外部类对象
        //先有外部类对象 再有 内部类对象
        OuterClass.InterClass interClass = outerClass.new InterClass();
        interClass.test();

        OuterClass.InterClass interClass2 = new OuterClass().new InterClass();
        //interClass2.test();

    }
}















