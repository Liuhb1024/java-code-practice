package DataStructure.StackandQueue.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 刘浩彬
 * @date 2023/10/12
 */
public class demo1 {
}

/**
 * 栈实现队列
 */
class MyStack {

    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    //将元素 x 压入栈顶

    /**
     * 入栈操作：
     * 入到不为空的队列中，如果都为空，入到qu1
     * @param x
     */
    public void push(int x) {
        if(qu1.isEmpty()){
            qu1.offer(x);
        }else if (!qu2.isEmpty()){
            qu2.offer(x);
        }else{
            qu1.offer(x);
        }
    }

    //移除并返回栈顶元素
    public int pop() {
        if (empty()) return -1;

        if (!qu1.isEmpty()){
            int size = qu1.size();
            for (int i = 0; i < size - 1; i++) {
                int tmp = qu1.poll();
                qu2.offer(tmp);
            }
            return qu1.poll();
        }else{
            int size = qu2.size();
            for (int i = 0; i < size- 1; i++) {
                int tmp = qu2.poll();
                qu1.offer(tmp);
            }
            return qu2.poll();
        }
    }

    // 返回栈顶元素
    public int top() {
        if (empty()) return -1;
        int tmp = -1;
        if (!qu1.isEmpty()){
            int size = qu1.size();
            for (int i = 0; i < size; i++) {
                tmp = qu1.poll();
                qu2.offer(tmp);
            }
            return tmp;
        }else{
            int size = qu2.size();
            for (int i = 0; i < size; i++) {
                tmp = qu2.poll();
                qu1.offer(tmp);
            }
            return tmp;
        }
    }

    /**
     * 2个队列都为空，表示栈为空
     * @return
     */
    public boolean empty() {
        //2个队列都为空的时候
        return qu1.isEmpty() && qu2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
