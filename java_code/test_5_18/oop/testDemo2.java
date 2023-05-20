package test_5_18.oop;
public class testDemo2 {
    public class Base {
        public void methodA(){
            System.out.println("Base中的methodA()");
        }
    }
    public class Derived extends Base{
        public void methodB(){
            System.out.println("Derived中的methodB()方法");
        }
        public void methodC(){
            methodB(); // 访问子类自己的methodB()
            methodA(); // 访问父类继承的methodA()
            // methodD(); // 编译失败，在整个继承体系中没有发现方法methodD()
        }
    }


}
