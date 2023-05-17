package test_5_16_1;

class Student{
    //成员变量 -- 定义在方法外部，类的内部
    public String name;
    public int age;

    //成员方法
    public void eat(){
        System.out.println(this.name+"在吃饭！");
        this.show();
    }

    public void show(){
        System.out.println(this.name +" 年龄："+this.age);
    }
/*
当成员变量 没有被初始化的时候
引用类型一般默认为null
基本类型默认为0
int -> 0
float -> 0.0
char -> '\u0000'
boolean -> false
 */

    /*
    构造方法
    非常特殊的一个方法：
    1.方法名必须和类名相同
    2.没有返回值
     */


    //构造方法：
    public Student(){
        this("小猪",18);

        /*
        this的三个作用：
        this(); 调用当前类中的其他构造方法，只能在当前的构造方法内部来使用，而且只能放在第一行
        this.data访问当前对象的属性
        this.func()调用当前对象的方法
        */

        System.out.println("不带参数的构造方法！");
    }//构造方法1
    //当一个类中 没有任何一个构造方法的时候 Java会帮你自动提供一个没有带参数的构造方法！


    public Student(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("带有两个参数的构造方法");
    }//构造方法2
    //当一个类当中 有一个构造方法的时候 Java就不会帮你提供一个构造方法

    //构造方法之间 是可以构成方法的重载
    //下面介绍重载
    /*
    重载是指在编程中，一个类或方法可以有多个不同的定义方式（参数、返回类型等），编译器会根据调用时所传入的参数类型和数量来自动选择合适的定义进行执行。这样的做法可以提高代码的灵活性和可读性，让程序员更加方便地使用方法。

例如，在Java语言中，当我们定义了两个方法名相同但参数列表不同的方法时，这两个方法就被称作是“重载方法”。假设有以下两个方法：

public void printNumber(int n) {
    System.out.println("The number is " + n);
}
public void printNumber(double f) {
    System.out.println("The floating point number is " + f);
}

当我们调用这些方法时，编译器会根据传入的参数类型和数量来自动选择调用哪个方法。例如：

printNumber(5);        // 调用printNumber(int n)方法
printNumber(3.14159);  // 调用printNumber(double f)方法


以上代码中，编译器会根据方法参数的类型和数量来自动选择调用的方法，这就是重载的使用场景。
     */

    //1.方法名相同
    //2.参数列表不同

    //构造方法的作用是对对象中的成员进行初始化，并不负责给对象开辟空间
}

/*
完成一个对象的构造，分两步（笼统来说）
1.分配内存
2.调用合适的构造方法
 */

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        //new后面的Student其实在调用不带参数的构造方法1
        //当调用完构造方法之后，对象才产生

        Student student2 = new Student("张飞",999);
        //构造方法2

        student.age = 100;
        student.name = "李四";
        student.eat();

    }
}
