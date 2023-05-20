package test_5_18.oop;

public class TestDemo3 {
    public class Base {
        public void methodA(){
            System.out.println("Base中的methodA()");
        }
        public void methodB(){
            System.out.println("Base中的methodB()");
        }
    }
    public class Derived extends Base{
        public void methodA(int a) {
            System.out.println("Derived中的method(int)方法");
        }
        public void methodB(){
            System.out.println("Derived中的methodB()方法");
        }
        public void methodC(){
            methodA(); // 没有传参，访问父类中的methodA()
            methodA(20); // 传递int参数，访问子类中的methodA(int)
            methodB(); // 直接访问，则永远访问到的都是子类中的methodB()，基类的无法访问到
        }
    }
}
