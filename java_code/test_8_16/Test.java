package test_8_16;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 刘浩彬
 * @date 2023/8/16
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);
        for(int x : list) {
            System.out.println(x);
        }

        System.out.println("=====");
        ListIterator<Integer> it =  list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        System.out.println("=====");
        ListIterator<Integer> it2 =  list.listIterator(list.size());
        while (it2.hasPrevious()) {
            System.out.print(it2.previous()+" ");
        }
        System.out.println();
    }


    public static void main1(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addFirst(1);
//        myLinkedList.addFirst(2);
//        myLinkedList.addFirst(3);
//        myLinkedList.addFirst(4);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
//        myLinkedList.addLast(2);
//        myLinkedList.addLast(3);
//        myLinkedList.addLast(4);
        //System.out.println(myLinkedList.size());
        //System.out.println(myLinkedList.contains(10));
        //myLinkedList.addIndex(0,99);
        //myLinkedList.addIndex(2,99);
        myLinkedList.display();
        myLinkedList.removeAllKey(1);
        myLinkedList.display();
    }

}
