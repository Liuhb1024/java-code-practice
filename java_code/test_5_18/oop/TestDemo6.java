package test_5_18.oop;

class Person1 {
    public String name;
    public int age;
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("构造方法执行");
    }
    {
        System.out.println("实例代码块执行");
    }
    static {
        System.out.println("静态代码块执行");
    }
}
public class TestDemo6 {
        public static void main(String[] args) {
            Person person1 = new Person("蔡徐坤",10);
            System.out.println("============================");
            Person person2 = new Person("王子异",20);
        }
    }

