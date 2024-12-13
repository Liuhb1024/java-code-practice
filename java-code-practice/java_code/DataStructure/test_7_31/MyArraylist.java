import test_7_31.MyArrayListIndexOutOfException;

import java.util.Arrays;

public class MyArraylist {

    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArraylist() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        //usedSize==0
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        //1、判断是否是满的，如果满的，那么进行扩容
        if (isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        //2、不满进行插入
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        /*if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;*/
        return this.usedSize == this.elem.length;
    }


    private boolean checkPosInAdd(int pos) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法");
            return false;
        }
        return true;//合法
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //判断下标是否是合法的
        if (!checkPosInAdd(pos)) {
            //throw new MyArrayListIndexOutOfException("添加方法的pos不合理！");
        }
        //判断是否是满的
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        //挪数据
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        //挪完了数据
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }


    private boolean checkPosInGet(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return false;
        }
        return true;//合法
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        if (!checkPosInGet(pos)) {
            //throw new MyArrayListIndexOutOfException("获取pos下标时，位置不合法");
        }
        //不用写判断空不空 没有问题的
        if (isEmpty()) {
            //throw new MyArrayListEmptyException("获取元素的时候，顺序表为空！");
        }
        return this.elem[pos];
    }


    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        if (!checkPosInGet(pos)) {
            //throw new MyArrayListIndexOutOfException("更新pos下标的元素，位置不合法");
        }
        //如果合法 ，那么其实不用判断顺序表为空的状态了
        if (isEmpty()) {
            //throw new MyArrayListEmptyException("顺序表为空！");
        }
        //顺序表为满的情况也可以更新
        this.elem[pos] = value;
    }


    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
        if (isEmpty()) {
            //throw new MyArrayListEmptyException("顺序表为空，不能删除！");
        }
        int index = indexOf(key);
        if (index == -1) {
            System.out.println("不存在你要删除的数据");
            return;
        }

        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        //删除完成
        this.usedSize--;
        // this.elem[usedSize] = null; 如果是引用类型 这里需要置为空
    }


    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        /*
        如果是引用数据类型 得一个一个置为空 这样做才是最合适的
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }
        this.usedSize = 0;
        */

        this.usedSize = 0;
    }
}