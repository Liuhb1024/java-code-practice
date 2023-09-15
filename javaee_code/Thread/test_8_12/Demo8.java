package Thread;

/**
 * @author 刘浩彬
 * @date 2023/9/15
 */
public class Demo8 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("线程开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束");
        });
        t.start();
        System.out.println(t.isAlive());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.isAlive());
    }
}
