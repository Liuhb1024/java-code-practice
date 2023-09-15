package Thread;

/**
 * @author 刘浩彬
 * @date 2023/9/15
 */
public class Demo7 {
    /*public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "这是一个新线程");
        t.start();
    }

     */
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "这是一个新线程");

        //设置 t 为后台线程
        t.setDaemon(true);
        t.start();
    }
}
