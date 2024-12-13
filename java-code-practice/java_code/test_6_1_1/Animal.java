package test_6_1_1;

/**
 * @author 刘浩彬
 * @date 2023/6/1
 */
public abstract class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*public void eat(){
            //这个一定会被重写的，所以没什么实现的必要，用abstract，直接抽象类，如下
        }*/
    public abstract void eat();
}
