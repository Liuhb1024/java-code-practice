package test_5_18.oop;

public class testDemo5 {
    public class Base {
        public Base(){
            System.out.println("Base()");
        }

    }
    public class Derived extends Base{
        public Derived(){
    // super(); // 注意子类构造方法中默认会调用基类的无参构造方法：super(),
    // 用户没有写时,编译器会自动添加，而且super()必须是子类构造方法中第一条语句，
    // 并且只能出现一次
            System.out.println("Derived()");
        }
    }
    public class Test {
        public  void main(String[] args) {
            Derived d = new Derived();
        }
    }
    /*
    结果打印：
    Base()
    Derived()
    */

}
