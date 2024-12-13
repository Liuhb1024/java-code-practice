package test_6_1_1;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */
//快捷键alt + enter

public class Dog extends Animal implements IRunning,ISwimming{
    public Dog(String name, int age){
        super(name,age);
    }

    @Override
    public void eat() {
        System.out.println(name + "吃狗粮！");
    }

    @Override
    public void run() {
        System.out.println(name + "正在用狗腿跑！");
    }

    @Override
    public void swim() {
        System.out.println(name + "正在用狗腿游泳！");
    }
}
