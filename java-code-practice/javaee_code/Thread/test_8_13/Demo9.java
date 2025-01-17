package Thread.test_8_13;

/**
 * @author 刘浩彬
 * @date 2023/9/15
 */
// 线程终止 - 优雅的方式
public class Demo9 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
           //Thread 类内部，有一个现成的标志位，可以用来判定当前的循环是否要结束
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 1. 假装没听见，循环继续正常执行
                     e.printStackTrace();
                    // 2. 加上一个break， 表示让线程立即结束
                    //break;
                    // 3. 做一些其他工作，完成之后再结束
                    //其他工作的代码放到这里
                    break; //这样就有更多可操作空间
                }
            }
        });
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("让 t 线程终止");
        t.interrupt();
    }
}
