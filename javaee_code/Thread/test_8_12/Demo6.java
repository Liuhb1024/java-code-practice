package Thread;

/**
 * @author 刘浩彬
 * @date 2023/9/15
 */
public class Demo6 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while (true){
                System.out.println("hello world");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        while (true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
