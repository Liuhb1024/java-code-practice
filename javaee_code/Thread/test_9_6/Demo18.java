package Thread.test_9_6;

/**
 * @author 刘浩彬
 * @date 2023/9/17
 */

// 破死锁
public class Demo18 {
    private static Object locker1 = new Object();
    private static Object locker2 = new Object();

    //此处的sleep很重要，要确保 t1 和 t2 都分别拿到一把锁之后，再进行后续动作
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (locker1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (locker2){
                System.out.println("t1 加锁成功");
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (locker2){
                System.out.println("t2 加锁成功");
            }

        });
        t1.start();
        t2.start();
    }
}
