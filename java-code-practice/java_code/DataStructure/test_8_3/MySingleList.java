package test_8_3;

/**
 * @author 刘浩彬
 * @date 2023/8/3
 */
//单链表
public class MySingleList {

    //静态内部类
    static class ListNode{
        public int val; //节点的值域
        public ListNode next; //下一个节点的地址

        //实例化节点对象
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode head;//表示当前链表的头节点

    //以穷举的方式创建一个链表
    public void createList(){
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        ListNode node5 = new ListNode(56);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        this.head = node1;
    }

    public void display() {
        ListNode cur = head;
        while (cur != null){
            System.out.println(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //得到单链表的长度
    public int size(){
        int count = 0;
        ListNode cur = head;
        if (cur!=null){
        while(cur != null){
            cur = cur.next;
            count++;
          }
        return count;
        }
        else{
            return -1;
        }
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = head;
            while(cur != null){
                if (key == cur.val){
                    return true;
                }
                  cur = cur.next;
            }
        return false;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);

        node.next = head;
        head = node;
    }


    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);

        ListNode cur = head;
        if (cur == null){
            head = node;
            return;
        }
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }


    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index < 0 || index > size()){
            System.out.println("index不合法");
            return;
        }
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size()){
            addLast(data);
            return;
        }

        /*ListNode node = new ListNode(data);
        ListNode cur = head;

        int tmp = index - 1;
        while (tmp != 0){
            cur = cur.next;
            tmp--;
        }
        node.next = cur.next;
        cur.next = node;
         */
        //将上面这一坨封装
        ListNode cur = findIndexSubOne(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 找到要删除节点位置的前一个节点
     * @param index
     * @return
     */
    private ListNode findIndexSubOne(int index){
        ListNode cur = head;
        int tmp = index - 1;
        while (tmp != 0){
            cur = cur.next;
            tmp--;
        }
        return cur;
    }




    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (head == null){
            return;
        }
        //单独删除头节点
        if (head.val == key){
            head = head.next;
            return;
        }

        ListNode cur = searchPrev(key);
        if (cur == null){
            System.out.println("没有你要删除的数字！");
            return;
        }
        ListNode del = cur.next;
        cur.next = del.next;

    }

    /**
     * 找到关键字key的前驱
     * @param key
     * @return
     */
    private ListNode searchPrev(int key){
        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }



    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = head;
        ListNode cur = head.next;

        if (head == null){
            return;
        }

        while (cur != null){
            if(cur.val == key){
                prev = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == key){
            head = head.next;
        }
    }

    public void clear() {
        this.head = null;
    }

    private void createIntersect(MySingleList.ListNode headA,
                                 MySingleList.ListNode headB){
        headB.next.next = headA.next.next;


    }



}
