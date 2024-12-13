package test_5_18.oop;

/*
修饰符 class 子类 extends 父类 {

// ...
}
 */
class Animal{
    public String name;
    public int age;
    public String color;

    public void eat(){
        System.out.println(name + "正在吃饭！");
    }
}

    class Dog extends Animal{
    /*
        public String name;
        public int age;
        public String color;

        public void eat(){
            System.out.println(name + "正在吃饭！");
        }
*/
        public void bark(){
            System.out.println(name + "正在汪汪叫！");
        }
    }

    class Cat extends Animal{
    /*
        public String name;
        public int age;
        public String color;

        public void eat(){
            System.out.println(name + "正在吃饭！");
        }
*/
        public void mew(){
            System.out.println(name + "正在咪咪叫！");
        }
    }

public class TestDemo1 {
    public static void main(String[] args) {

    }
}
