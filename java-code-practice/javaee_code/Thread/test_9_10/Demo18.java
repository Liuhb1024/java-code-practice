package Thread.test_9_10;

/**
 * @author 刘浩彬
 * @date 2023/9/18
 */
public class Demo18 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 结束！");
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    t1.join();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束！");
        });
        t1.start();
        t2.start();
        System.out.println("主线程结束！");
    }
}
