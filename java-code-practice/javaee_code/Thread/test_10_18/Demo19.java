package Thread.test_10_18;

import java.util.PriorityQueue;

/**
 * @author 刘浩彬
 * @date 2023/10/19
 */
// 通过这个类，描述了一个任务
class MyTimerTask implements Comparable<MyTimerTask>{
    //要有一个执行的任务
    private Runnable runnable;
    //还要有一个执行任务的时间
    private long time;

    //此处的 delay 就是 schedule 方法传入的 “相对时间”
    public MyTimerTask(Runnable runnable, long delay){
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        //这样的写法是，就是让队首元素是最小时间的值
        //到底是 谁-谁 不要背，遇到了就试试看咯
        return (int) (this.time - o.time);
        //如果是想让队首元素是最大时间的值
        //return o.time - this.time;
    }

    public long getTime(){
        return time;
    }
    public Runnable getRunnable(){
        return runnable;
    }
}

// 我们自己搞得定时器
class MyTimer{
    //使用一个数据结构 保存所有要安排的任务
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();

    // 使用这个对象作为锁对象
    private Object locker = new Object();

    public void  schedule(Runnable runnable, long delay){
        synchronized (locker){
            queue.offer(new MyTimerTask(runnable, delay));
            locker.notify();
        }
    }

    // 搞一个扫描线程
    public MyTimer(){
        // 创建一个扫描线程
        Thread t = new Thread(()->{
            // 扫描线程 需要不停的扫描队首元素，看是否到达时间
            while (true){
                try {
                    synchronized (locker){
                        //不要使用 if 作为 wait 的判定条件，应该使用 while
                        //使用 while 的目的是为了在 wait 被唤醒的时候，再次确认一下条件
                        while (queue.isEmpty()){
                            // 使用 wait 进行等待
                            // 这里的 wait 需要有另外的线程唤醒
                            // 添加了新任务，就应该唤醒
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        // 比较一下看当前的队首元素是否可以执行了
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()){
                            // 当前时间已经到达任务时间，就可以执行任务了
                            task.getRunnable().run();
                            //任务执行完了，就可以从队列中删除了
                            queue.poll();
                        }else {
                            // 当前时间未到达任务时间，暂时不执行任务了
                            //暂时啥都不干，等待下一轮的循环判定
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}

public class Demo19 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        },3000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        },1000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        },2000);
        System.out.println("程序启动！");
    }
}
