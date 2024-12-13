package test_6_1_1;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */
public class Bird extends Animal implements IRunning,IFlying{
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(name + "正在吃鸟粮！");
    }

    @Override
    public void fly() {
        System.out.println(name + "正在用翅膀飞！");
    }

    @Override
    public void run() {
        System.out.println(name + "正在用鸟腿跑！");
    }
}
