package DataStructure.StackandQueue;

import javax.naming.LinkLoopException;
import java.util.*;

/**
 * @author 刘浩彬
 * @date 2023/10/8
 */
public class Test {

    public static void main(String[] args) {
        Deque<Integer> queue2 = new LinkedList<>();
        Deque<Integer> queue22 = new ArrayDeque<>();
        queue22.offer(1);

        Deque<Integer>stack = new ArrayDeque<>();
        stack.push(1);
    }

    public static void main4(String[] args) {
        Deque<Integer> queue2 = new LinkedList<>();

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);

        System.out.println(queue1.poll());
        System.out.println(queue1.peek());
    }

    public static void main3(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
    }
    public static void main2(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
    }
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(23);
        stack.push(34);

        Integer x = stack.pop();
        System.out.println(x);
    }
}
