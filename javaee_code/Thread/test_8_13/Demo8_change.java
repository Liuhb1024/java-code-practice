package Thread.test_8_13;

/**
 * @author 刘浩彬
 * @date 2023/9/15
 */

/**
 * 当前咱们这个代码，是使用了一个成员变量isQuit,来作为标志位
 * 如果把isQuit改成main方法中的局部变量，是否可以呢？为啥~~
 */

public class Demo8_change {
    //private static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {

        boolean isQuit = false;

        Thread t = new Thread(() ->{
            while (!isQuit){
                //此处的打印可以替换成任意的逻辑来表示线程的实际工作内容
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程工作完毕");
        });

        t.start();
        Thread.sleep(5000);

        //isQuit = true;
        //常量变了

        System.out.println("已过 5s 设置 isQuit 为 true");
    }
}
