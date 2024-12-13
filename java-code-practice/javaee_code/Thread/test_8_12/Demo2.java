

/**
 * @author 刘浩彬
 * @date 2023/9/14
 */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();

        while (true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
