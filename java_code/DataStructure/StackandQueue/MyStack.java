package DataStructure.StackandQueue;

import java.util.Arrays;

/**
 * @author 刘浩彬
 * @date 2023/10/8
 */
public class MyStack {
    private int[] elem;
    private int usedSize;

    private static final int DEFAULT_CAPACITY = 10;

    public MyStack(){
        this.elem=new int[DEFAULT_CAPACITY];
    }

    //判断是否为满
    private boolean isFull(){
        return usedSize == elem.length;
    }

    //判空
    private boolean isEmpty(){
        return usedSize == 0;
    }

    //入栈
    public void push(int val){
        if (isFull()){
            System.out.println("栈已经满了，先进行扩容");
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        this.elem[usedSize++] = val;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new EmptyException();
        }
        int val = this.elem[usedSize-1];
        usedSize--;
        return val;
    }

    //获取栈顶元素
    public int peek(){
        if (isEmpty()){
            throw new EmptyException();
        }
        return this.elem[usedSize-1];
    }

    //栈的大小
    public int size(){
        return usedSize;
    }

    //清空
    public void clear(){
        for (int i = 0; i <= usedSize; i++) {
            elem[i] = 0;
        }
        usedSize = 0;
    }
}
