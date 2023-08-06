package test_8_3;

import test_7_13.MyArrayList;

/**
 * @author 刘浩彬
 * @date 2023/8/3
 */
public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        //mySingleList.createList();
        mySingleList.addFirst(12);
        mySingleList.addFirst(23);
        mySingleList.addFirst(34);
        mySingleList.addFirst(45);
        mySingleList.addFirst(56);
        mySingleList.display();

        mySingleList.addIndex(0,100);
        mySingleList.display();

        mySingleList.addIndex(5,200);
        mySingleList.display();

        mySingleList.addIndex(3,900);
//        mySingleList.addLast(199);
        mySingleList.display();
        /*System.out.println(mySingleList.size());
        System.out.println(mySingleList.contains(12));
        System.out.println(mySingleList.contains(13));
         */
        //System.out.println("12344");
    }
}
