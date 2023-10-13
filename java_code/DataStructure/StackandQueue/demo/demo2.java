package DataStructure.StackandQueue.demo;

import java.util.Stack;

/**
 * @author 刘浩彬
 * @date 2023/10/12
 */
public class demo2 {
}

//定义两个栈

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * 入的时候 统一放到s1当中
     * @param x
     */
    public void push(int x) {
        s1.push(x);
    }

    //出的时候，同一出s2
    public int pop() {
        if (empty()) return -1;
        if (s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {if (empty()) return -1;
        if (s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();

    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */