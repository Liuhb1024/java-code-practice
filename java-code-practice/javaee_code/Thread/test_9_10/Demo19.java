package Thread.test_9_10;

/**
 * @author 刘浩彬
 * @date 2023/9/18
 */
public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait 之前");
            //把 wait 放入 synchronized 里面来调用，保证确实是拿到锁
            object.wait();
            // wait 会持续地阻塞等待下去，直到其他线程调用 notify 唤醒

            System.out.println("wait 之后");
        }
    }
}
