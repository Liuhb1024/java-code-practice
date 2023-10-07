package Thread.test_10_7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author 刘浩彬
 * @date 2023/10/7
 */
//阻塞队列
public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
//        BlockingDeque<String> queue = new ArrayBlockingQueue<>();
        queue.put("111");
        queue.put("222");
        queue.put("333");
        queue.put("444");
        String elem = queue.take();
        System.out.println(elem);
        elem = queue.take();
        System.out.println(elem);
        elem = queue.take();
        System.out.println(elem);
        elem = queue.take();
        System.out.println(elem);
        elem = queue.take();
        System.out.println(elem);
    }
}
