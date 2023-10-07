package Thread.test_10_7;

/**
 * @author 刘浩彬
 * @date 2023/10/7
 */
//模拟实现阻塞队列
//不写成泛型了，直接让这个队列里面存储字符串
    class MyBlockingQueue{
        //此处这里的最大长度，也可以指定构造方法，有构造方法的参数来制定
        private String [] data = new String[1000];
        //队列的起始位置
        private int head = 0;
        //队列的结束位置 的 下一个位置
        private int tail = 0;
        //队列中有效元素的个数
        private int size = 0;

//        private final Object locker = new Object();

        //提供核心方法，入队列和出队列
        //入队列
        public void put(String elem) throws InterruptedException {
//            synchronized (locker){
            synchronized (this){
                if (size == data.length){
                    //队列满了
                    //如果队列满 ，继续插入元素，就会阻塞
                    this.wait();
                }
                //如果队列没满，真正的往里面添加元素
                data[tail] = elem;
                tail++;
                // 如果 tail 自增之后，到达了数组末尾，这个时候就需要让它回到开头（环形队列）
                if(tail == data.length){
                    tail = 0;
                }
                size++;
                //这个 notify 用来唤醒 take 中的 wait
                this.notify();
            }
        }

        //出队列
        public String take() throws InterruptedException {
//            synchronized (locker){
            synchronized (this){
                if(size == 0){
                    //队列空了
                    this.wait();

                }
                //队列不空，就可以把队首元素（head 位置的元素）删除掉，并进行返回
                String ret = data[head];
                head++;
                if (head == data.length){
                    head = 0;
                }
                size--;
                //这个notify用来唤醒 put 中的 wait
                this.notify();
                return ret;
            }
        }
}

public class Demo24 {
    public static void main(String[] args) {

    }
}
