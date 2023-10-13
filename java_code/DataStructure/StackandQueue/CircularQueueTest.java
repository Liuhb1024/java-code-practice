package DataStructure.StackandQueue;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

import java.awt.*;

/**
 * @author 刘浩彬
 * @date 2023/10/12
 */
public class CircularQueueTest {

}
class MyCircularQueue {

    private  int[] elem;
    private int front;//队头下标
    private int rear;//队尾下标


    public MyCircularQueue(int k) {
        this.elem = new int[k];

    }

    //向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if (isFull()) return false;
        elem[rear] = value;
        rear = (rear + 1) % elem.length;
        return true;
    }

    //从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        //1.空的 不能出
        if (isEmpty()) return false;
        //2.不空 则保存 队头元素 然后 front 往后走
        front = (front + 1) % elem.length;
        return true;
    }

    //得到队头元素
    public int Front() {
        if (isEmpty()) return -1;
        return elem[front];
    }


    //获取队尾元素
    public int Rear() {
        if (isEmpty()) return -1;
        int index = (rear == 0) ? elem.length - 1: rear - 1;
        return elem[index];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        if ((rear + 1) % elem.length == front){
            return true;
        }
        return false;
    }
}


