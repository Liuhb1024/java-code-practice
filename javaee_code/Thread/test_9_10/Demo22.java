package Thread.test_9_10;

/**
 * @author 刘浩彬
 * @date 2023/9/19
 */
//懒汉模式

class SingletonLazy{
    private static volatile SingletonLazy instance = null;
    public static SingletonLazy getInstance(){
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    private SingletonLazy(){}
}

public class Demo22 {
    public static void main(String[] args) {
        //此外又有一个实例，这就不是单例了
        //Singleton s1 = new Singleton();
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1 == s2);
        //true
    }
}
