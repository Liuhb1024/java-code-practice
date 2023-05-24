package test_5_24.typoraNoteTest;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * @author 刘浩彬
 * @date 2023/5/24
 */
class Animal{
    public String name;
    public int age;

    public Animal(String name, int age){
        this.age = age;
        this.name = name;
    }

    public void eat(){
        System.out.println(name+"正在吃饭！");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
//---------------------------------------------------------
class Dog extends Animal{
    public Dog(String name,int age){
        super(name, age);
    }

    public void wangWang(){
        System.out.println(name+"正在汪汪！");
    }

    //提示、警告的作用
    @Override
    public void eat(){
        System.out.println(name+"正在吃狗粮！");
    }
}
//-----------------------------------------------------------
class Bird extends Animal{
    public Bird(String name, int age){
        super(name, age);
    }

    public void fly(){
        System.out.println(name+"正在飞！");
    }
}
//------------------------------------------------------------
public class demo1 {

    public static void main(String[] args) {
        Animal animal1 = new Dog("小狗",10);
        animal1.eat();
    }

    /**
     * 向上转型有三种方式可以发生
     * 1.直接赋值
     * 2.方法传参的方式
     * 3.返回值
     * @param args
     */
    public static void main2(String[] args) {
        //向上转型
        /**
         *  Dog dog = new Dog("小狗",20);
         *
         *         Animal animal = dog;
         */
        //父类引用 引用了子类对象
        Animal animal = new Dog("小狗",10);
        Animal animal2 = new Bird("小鸟",20);

        Dog dog = new Dog("小狗",10);
        Bird bird = new Bird("小鸟",20);

        func1(dog);
        func1(bird);

        Animal animal1 = func2();

        Animal animal3 = func3();
    }

    public static Animal func2(){
        /**
         * Bird bird = new Bird("小鸟"，10)；
         * return bird;
         */
        return new Bird("小鸟",20);
    }

    public static Bird func3() {
        return new Bird("小鸟",20);

    }

    public static void func1(Animal animal){

    }
    public static void main1(String[] args) {
        Dog dog = new Dog("小狗",20);
        dog.eat();
        dog.wangWang();
        System.out.println("===================");
        Animal animal = new Animal("animal",10);
        animal.eat();
        //animal.wangWang();
    }
}