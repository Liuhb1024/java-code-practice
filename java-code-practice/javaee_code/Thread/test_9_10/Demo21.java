package Thread.test_9_10;

/**
 * @author 刘浩彬
 * @date 2023/9/19
 */
// 饿汉模式
class Singleton{
    private static Singleton instance = new Singleton();
    //通过这个方法来获取到刚才的实例
    //后续如果想使用这个类的实例，都通过 getInstance 方法来获取
    public static Singleton getInstance(){
        return instance;
    }
    //把构造方法设置为私有，此时类外面的其他代码，就无法 new 出这个类的对象
    private Singleton(){}
}

public class Demo21 {
    public static void main(String[] args) {
        //此外又有一个实例，这就不是单例了
        //Singleton s1 = new Singleton();
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
        //true
    }
}
