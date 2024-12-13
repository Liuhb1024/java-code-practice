package Thread.test_10_18;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 刘浩彬
 * @date 2023/10/18
 */
public class Demo18 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 给定时器安排了一个任务， 预定在xxx时间内去执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3000ms 后执行定时器的任务！");
            }
        },3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000ms后 执行定时器的任务！");
            }
        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1000ms 后执行定时器的任务！");
            }
        },1000);
        System.out.println("程序启动！");
    }
}
