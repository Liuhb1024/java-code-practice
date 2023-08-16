package test_8_16;

import com.sun.media.sound.DLSSample;

/**
 * @author 刘浩彬
 * @date 2023/8/16
 */
public class MyLinkedList {

    static class ListNode{
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;//定义双向链表的头节点

    public ListNode last;//定义双向链表的尾巴


    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }


    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if (head == null){
            head = node;
            last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }


    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        checkIndex(index);
        if(index == 0){
            addFirst(data);
            return;
        }
        else if (index == size()){
            addLast(data);
            return;
        }

        ListNode node = new ListNode(data);
        ListNode cur = head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;

    }

    private void checkIndex(int index){
        if (index < 0 || index > size()){
            throw new IndexOutOfException("index 不合法");
        }
    }

    //查找是否包含关键字key是否在链表当中
    public boolean contains(int key){
        ListNode cur =this.head;
        while(cur != null){
            if (cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                //删除头节点
                if (cur == head) {
                    head = head.next;
                    if (head != null) {
                        //考虑只有一个节点的情况
                        head.prev = null;
                    }else {
                        last = null;
                    }
                } else {
                    //删除中间节点以及尾巴节点
                    if (cur.next != null) {
                        //中间节点
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    } else {
                        //尾巴节点
                        cur.prev.next = cur.next;
                        last = last.prev;
                    }
                }
                return;
            } else {
                cur = cur.next;
            }
        }
    }


    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                //删除头节点
                if (cur == head) {
                    head = head.next;
                    if (head != null) {
                        //考虑只有一个节点的情况
                        head.prev = null;
                    }else {
                        last = null;
                    }
                } else {
                    //删除中间节点以及尾巴节点
                    if (cur.next != null) {
                        //中间节点
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    } else {
                        //尾巴节点
                        cur.prev.next = cur.next;
                        last = last.prev;
                    }
                }
                //return;
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }
    }


    //得到链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }


    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public void clear(){
        ListNode cur = head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        last = null;
    }

}
