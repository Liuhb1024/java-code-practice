package Thread.test_8_13;

/**
 * @author 刘浩彬
 * @date 2023/9/15
 */
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(" t 线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        //让主线程来等待 t 线程执行结束
        //一旦调用 join，主线程就会触发阻塞， 此时 t 线程就会趁机完成后续的工作
        //一旦阻塞到 t 执行完毕了，join才会解除阻塞，继续执行
        System.out.println("join 开始等待");
        t.join(1000);//最好是有时间等待,不要死等
        System.out.println("join 等待结束");
    }
}
