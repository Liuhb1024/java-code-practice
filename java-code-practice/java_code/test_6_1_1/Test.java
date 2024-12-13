package test_6_1_1;//多接口

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */

public class Test {

    public static void test1(Animal animal){
        animal.eat();
    }

    public static void test2(IRunning iRunning){
        iRunning.run();
    }

    public static void test3(ISwimming iSwimming){
        iSwimming.swim();
    }

    public static void test4(IFlying iFlying){
        iFlying.fly();
    }

    public static void main(String[] args) {
        Bird bird = new Bird("小鸟",1);
        Dog dog = new Dog("小狗",10);
        test2(bird);
        test2(dog);
        System.out.println("========================");

        //test3(bird); 报错辣！！！！！！！！！

        test3(dog);
        System.out.println("========================");

        //test4(dog); 报错辣！！！！！！！！！！

        test4(bird);

        System.out.println("========================");

        test2(new Robot());
    }

    public static void main1(String[] args) {
        Bird bird = new Bird("小鸟",1);
        Dog dog = new Dog("小狗",10);

        test1(bird);
        test1(dog);
    }
}
