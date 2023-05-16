package test_5_16;

//对象的产生依赖于类
//类名一定要 采用 大驼峰的形式
class WashMachine{
    //成员属性/字段 ： 是定义在类里边 方法的外边
    public String brand; // 品牌
    public String type; // 型号
    public double weight; // 重量
    public double lenght; // 长
    public double weidth; // 宽
    public double height; // 高
    public String color; // 颜色

    //行为 / 成员方法
    public void WashClothes(){ // 洗衣服
        System.out.println("洗衣功能");
    }
    public void dryClothes(){ // 脱水
        System.out.println("脱水功能");
    }
    public void SetTime(){ // 定时
        System.out.println("定时功能");
    }
}
/*
注意事项
      类名注意采用大驼峰定义
      成员前写法统一为public，后面会详细解释
      此处写的方法不带 static 关键字. 后面会详细解释
 */

class Dog{
    //属性
    public String name;
    public int age;
    public String color;

    //行为
    public void eat(){
        System.out.println(name + "吃饭！");
    }

    public void bark(){
        System.out.println(name+"汪汪汪汪");
    }

}
//注意事项：
//    1.一般一个文件当中只定义一个类
//    2. main方法所在的类一般要使用public修饰(注意：Eclipse默认会在public修饰的类中找main方法)
//    3. public修饰的类必须要和文件名相同
//    4. 不要轻易去修改public修饰的类的名称，如果要修改，通过开发工具修改(给同学演示)。

public class Test {
    public static void main(String[] args) {
        System.out.println("1234");
        //类的实例化
        //通过new关键字 实例化一个Dog对象
        //用类类型创建对象的过程，称为类的实例化
        Dog dog = new Dog();
        Dog dog2 = new Dog();
        //dog就是一个引用，指向了Dog对象
        /*
        如何访问name color age 、对象的属性
        通过对象的引用来访问对象的属性
        在这之前 name = null;
               age = null;
               color = null;
         对象的成员属性在没有赋值的时候，引用类型默认是null，简单类型就是对应的0值
         */
        dog.name = "小黑";
        dog.age = 10;
        dog.color = "白色";
        int a = 10;
        System.out.println(dog.age);
        System.out.println(dog.color);
        System.out.println(dog.name);

        dog.eat();
        dog.bark();

        //每次new一个对象，都会开辟一块内存
        dog2.name = "小黄";
        dog2.age = 100;
        dog2.color = "蓝色";
        int b = 10;
        System.out.println(dog2.age);
        System.out.println(dog2.color);
        System.out.println(dog2.name);

        dog2.eat();
        dog2.bark();
        /*
         1. 类只是一个模型一样的东西，用来对一个实体进行描述，限定了类有哪些成员.
         2. 类是一种自定义的类型，可以用来定义变量.
         3. 一个类可以实例化出多个对象，实例化出的对象 占用实际的物理空间，存储类成员变量
         4. 做个比方。类实例化出对象就像现实中使用建筑设计图建造出房子，类就像是设计图，只设计出需要什么东
            西，但是并没有实体的建筑存在，同样类也只是一个设计，实例化出的对象才能实际存储数据，占用物理空间
         */

    }
}
