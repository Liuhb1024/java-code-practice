package test_5_18.oop;


class Person {
    public String name;
    public int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person：构造方法执行");
    }
    {
        System.out.println("Person：实例代码块执行");
    }
    static {
        System.out.println("Person：静态代码块执行");
    }
}
class Student extends Person{
    public Student(String name,int age) {
        super(name,age);
        System.out.println("Student：构造方法执行");
    }
    {
        System.out.println("Student：实例代码块执行");
    }
    static  {
        System.out.println("Student：静态代码块执行");
    }
}
public class testDemo7 {
    public static void main(String[] args) {
        Student student1 = new Student("蔡徐坤",19);
        System.out.println("===========================");
        Student student2 = new Student("王子异",20);
    }
    public static void main1(String[] args) {
        Person person1 = new Person("蔡徐坤",10);
        System.out.println("============================");
        Person person2 = new Person("王子异",20);
    }
}