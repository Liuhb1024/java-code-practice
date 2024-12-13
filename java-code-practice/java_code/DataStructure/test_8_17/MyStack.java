package test_8_17;

import java.util.Arrays;

/**
 * @author 刘浩彬
 * @date 2023/8/17
 */
public class MyStack {
    private int[] elem;
    private int usedSize;

    private static final int DEFAULT_CAPACITY = 10;

    public MyStack(){
         this.elem = new int[DEFAULT_CAPACITY];
    }

//入栈：
    //判断栈是否满了
    private boolean isFull(){
        if (this.usedSize == elem.length){
            return true;
        }
        return false;
    }

    public void push(int val){
        if (isFull()){
            //扩容
            this.elem = Arrays.copyOf(this.elem,2*elem.length);
        }
        this.elem[usedSize++] = val;
    }

//出栈
    public int pop(){
        if (this.usedSize == 0){
            //没有元素
            //报异常
            throw new  RuntimeException("栈内无元素，无法出栈");
        }
        //获取栈顶元素
        int val = this.elem[usedSize - 1];
        //size -1 之后，下一次插入会覆盖原始元素,利用覆盖发
        this.usedSize--;
        return val;
    }
//获取栈顶元素
    public int peek(){
        if (this.usedSize == 0){
            //没有元素
            //报异常
            throw new  RuntimeException("栈内无元素，无法出栈");
        }
        return this.elem[this.usedSize - 1];
    }
}
