package Thread.test_10_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 刘浩彬
 * @date 2023/10/19
 */
//线程池

public class Demo27 {
    public static void main(String[] args) {
        // 工厂模式
        //ExecutorService service = Executors.newCachedThreadPool();
        // 下面这个就是固定线程数量
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });

    }
}
