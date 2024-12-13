package test_5_17;

class Student{

    //普通成员变量  --->  属于对象
    //访问方式：对象的引用.xxx
    private String name;
    private int age;

    //public String classRoom;
    //静态成员变量
    public static String classRoom;
    /*
    当把classRoom使用static修饰之后
    就不存在于对象当中了
    classRoom会在方法区中，被共用（） 会警告：student1.classRoom = "109";

     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(){
    }

    public void eat(){
        System.out.println(this.name + "在吃饭！");
    }

    public void show(){
        System.out.println("姓名："+this.name+"年龄："+this.age);
    }

    public static void func(){
        System.out.println("这是一个静态方法!");
        //show();静态方法内部 不能直接调用非静态方法
        Student student = new Student();
        //报错：System.out.println(student.show());
        student.show();
        /*
        静态方法 不能直接调用非静态的成员方法
        或者调用成员变量

        static 方法里面 不能使用this
         */
    }


    public Student(String name,int age){
    this.name = name;
    this.age = age;
    }

}

public class Test {
    public static void main(String[] args) {

        Student.classRoom = "109";
        /*
        访问方式：
              类名.xxx
         */
        Student student1 = new Student("A",10);
        //student1.classRoom = "109";

        Student student2 = new Student("B",20);
        //student2.classRoom = "109";

        Student student3 = new Student("C",30);
        //student3.classRoom = "109";

        Student.func();
        /*
        静态成员变量 和 静态成员方法 有的书上
        或者资料上 会叫做: 类变量和类方法
         */

    }
}
