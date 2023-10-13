package test_8_17;

import java.util.Stack;

/**
 * @author 刘浩彬
 * @date 2023/8/17
 */
public class Test {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(12);
        myStack.push(23);
        myStack.push(34);

    }



    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(23);
        stack.push(34);

        Integer x = stack.pop();
        System.out.println(x);

        int ret = stack.peek();
        System.out.println(ret);

        ret = stack.peek();
        System.out.println(ret);

        System.out.println(stack.size());
    }
}
