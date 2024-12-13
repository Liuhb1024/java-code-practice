package test_5_18.oop;

public class TestDemo4 {
    public class Base {
        int a;
        int b;
        public void methodA(){
            System.out.println("Base中的methodA()");
        }
        public void methodB(){
            System.out.println("Base中的methodB()");
        }
    }

    public class Derived extends Base{
        int a; // 与父类中成员变量同名且类型相同
        char b; // 与父类中成员变量同名但类型不同
        // 与父类中methodA()构成重载
        public void methodA(int a) {
            System.out.println("Derived中的method()方法");
        }

        //与基类中methodB()构成重写(即原型一致，重写后序详细介绍)
        public void methodB(){
            System.out.println("Derived中的methodB()方法");
        }
        public void methodC(){
// 对于同名的成员变量，直接访问时，访问的都是子类的
            a = 100; // 等价于： this.a = 100;
            b = 101; // 等价于： this.b = 101;
// 注意：this是当前对象的引用
// 访问父类的成员变量时，需要借助super关键字
// super是获取到子类对象中从基类继承下来的部分
            super.a = 200;
            super.b = 201;
// 父类和子类中构成重载的方法，直接可以通过参数列表区分清访问父类还是子类方法
            methodA(); // 没有传参，访问父类中的methodA()
            methodA(20); // 传递int参数，访问子类中的methodA(int)
// 如果在子类中要访问重写的基类方法，则需要借助super关键字
            methodB(); // 直接访问，则永远访问到的都是子类中的methodA()，基类的无法访问到
            super.methodB(); // 访问基类的methodB()
        }
    }
}
