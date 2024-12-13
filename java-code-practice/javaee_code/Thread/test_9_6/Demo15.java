package Thread.test_9_6;

/**
 * @author 刘浩彬
 * @date 2023/9/17
 */
public class Demo15 {
    private static Object locker = new Object();

    public static void func1(){
        synchronized (locker){
            func2();
        }
    }

    public  static void func2(){
        func3();
    }

    public static void func3(){
        func4();
    }

    public static void func4(){
        synchronized (locker){

        }
    }

    public static void main(String[] args) {

    }
}
