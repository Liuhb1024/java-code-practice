package Thread.test_9_10;

/**
 * @author 刘浩彬
 * @date 2023/9/18
 */
// notify 唤醒
public class Demo20 {
    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(()->{
            synchronized (object){
                System.out.println(" wait 之前");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" wait 之后");
            }
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object){
                System.out.println(" 进行通知 ");
                object.notify();
            }
        });
        t1.start();
        t2.start();
    }
}
