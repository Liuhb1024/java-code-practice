package Thread.test_10_19;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author 刘浩彬
 * @date 2023/10/19
 */
//模拟实现一个简单的线程池

class MyThreadPool{
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    //通过这个方法，把任务添加到队列中
    public void submit(Runnable runnable) throws InterruptedException {
        //此处我们的拒绝策略 相当于是第五种策略了
        queue.put(runnable);
    }

    public MyThreadPool(int n){
        // 创建出 n 个线程，负责执行上述队列中的任务
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(()->{
                //让这个线程从队列中消费任务，并进行执行
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}

public class Demo28 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int id = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务" + id);
                }
            });
        }
    }
}
