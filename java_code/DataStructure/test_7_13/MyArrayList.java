package test_7_13;

import java.util.Arrays;

/**
 * @author 刘浩彬
 * @date 2023/7/13
 */
public class MyArrayList {
    private int[] elem; //用来存放数据
    private int userSize;//代表当前顺序表中的有效数据个数

    private static final int DEFAULT_SIZE = 10;//定义静态常量，默认MyArrayList的容量是10，final-不能改

    public MyArrayList(){
        this.elem = new int [DEFAULT_SIZE];
    }

    /**
     * 指定容量
     * @param initCapacity
     */
    public MyArrayList(int initCapacity){
        this.elem = new int [initCapacity];
    }

    // 打印顺序表，注意：该方法并不是顺序表中的方法，为了方便看测试结果给出的
    /**
     * 实际上就是遍历数组
     */
    public void display() {
        for (int i = 0; i < this.userSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }

    public void display2() {
        for (int i = 0; i < userSize; i++) {
            System.out.print(elem[i]+" ");
        }
    }


    // 新增元素,默认在数组最后新增
    //数据结构是一门逻辑非常严谨的学科
    public void add(int data) {
        if (isFull()){
            //扩容
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        this.elem[this.userSize] = data;
        this.userSize++;

    }

    public boolean isFull(){
        if(this.userSize == this.elem.length){
            return true;
        }
        return false;
    }


    // 在 pos 位置新增元素
    //add方法重载
    public void add(int pos, int data) {

        //对pos的检查
        if (pos < 0 || pos > this.userSize){

            throw new RuntimeException(pos + "pos位置不合法");
            /*
            System.out.println("pos位置不合法");
            return;
             */
        }

        if (isFull()){
            //扩容
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        for (int i = this.userSize - 1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }

        this.elem[pos] = data;

        this.userSize++;
    }


    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.userSize; i++) {
            if (this.elem[i] == toFind){
                return true;
            }
        }
        /**
         * 如果这里找的是一个引用类型的话，this.elem[i] == toFind就不能用等号了
         * equals -> 返回值是true false
         * compare to -> 整型 -> 比较大于 小于 等于
         */
        return false;
    }


    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.userSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 检查pos位置是否合法
     * [0,this.useSize)
     * @param pos
     */

    private void checkPos(int pos){
        if (pos < 0 || pos >= this.userSize){

            throw new RuntimeException(pos + "pos位置不合法");
            /*
            System.out.printl n("pos位置不合法");
            return;
             */
        }
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        checkPos(pos);
        return this.elem[pos];
    }



    // 给 pos 位置的元素设为 value(理解为更新)
    public void set(int pos, int value) {
        checkPos(pos);

        this.elem[pos] = value;
    }


    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        //先找有没有这个数
        int index = indexOf(toRemove);
        if (index == -1){
            System.out.println("没有这个数据！");
            return;
        }
        for (int i = index; i < this.userSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }

        /*
        引用类型
        this.elem[useSize - 1] = null;
         */

        this.userSize--;

    }


    // 获取顺序表长度
    public int size() {
        return this.userSize;
    }


    // 清空顺序表
    // 清空顺序表
    public void clear() {
        /*
        如果elem是引用类型
        for (int i = 0; i < this.userSize; i++) {
            this.elem[i] = null;
        }
         *///内存泄露解决
        this.userSize = 0;

    }


}
