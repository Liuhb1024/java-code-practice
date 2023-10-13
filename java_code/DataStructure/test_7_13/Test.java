package test_7_13;

import java.util.*;

/**
 * @author 刘浩彬
 * @date 2023/7/13
 */
public class Test {

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        row.add(1);
        ret.add(row);
        //这上面相当于第一行已经处理完
        //下面从第二行开始
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);//新的一行的第一个值

            //这里处理中间列
            //上一行
            List<Integer>prevRow = ret.get(i-1);
            for (int j = 1; j < i; j++) {

                //[i][j] = [i-1][j] + [i-1][j-1]
                int x = prevRow.get(j) + prevRow.get(j-1);
                curRow.add(x);
            }

            curRow.add(1);//新的一行的最后一个值

            ret.add(curRow);

        }

        return ret;
    }




    public static void main6(String[] args) {

        List<List<Integer>> ret1 = new ArrayList<>();
        ret1.add(new ArrayList<>());
        ret1.get(0).add(1);


        List<Integer> ret2 = new ArrayList<>();
        ret2.add(1);
        System.out.println(ret2.get(0));

    }


    /**
     * 笔试题：cvte
     * str1:welcome to cvte
     * str2:come
     * 描述：删除第一个字符串当中出现的所有的第二个字符串的字符！
     * 结果：wtl t vt
     * 要求用ArrayList完成！！！！
     * @param str1
     * @param str2
     * @return
     */
    public static List<Character> func(String str1,String str2){
        //1.遍历str1这个字符串 看看当中是不是存在str2中的字符
        List<Character>list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                list.add(ch);
            }
        }
        return list;
    }

    public static void main5(String[] args) {
        String str1 = "welcome to ctve";
        String str2 = "come";
        List<Character>ret = func(str1,str2);
        for (char ch : ret){
            System.out.print(ch);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer>list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        //第一种遍历
        System.out.println("第一种遍历:");
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i)+" ");
        }
        System.out.println();

        //第二种遍历
        System.out.println("第二种遍历:");
        for (Integer x :list2){
            System.out.print(x+" ");
        }
        System.out.println();

        //第三种遍历---迭代器
        Iterator<Integer> it = list2.iterator();
        System.out.println("第三种遍历:");
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();

        System.out.println("=====================");

        ListIterator<Integer>listIterator = list2.listIterator();
        System.out.println("第三种遍历:");
        while(listIterator.hasNext()){
            System.out.print(listIterator.next()+" ");
        }
        System.out.println();


        System.out.println("=====================");

        //升华版本
        ListIterator<Integer>listIterator2 = list2.listIterator(list2.size());
        System.out.println("第三种遍历升华:");
        while(listIterator2.hasPrevious()){
            System.out.print(listIterator2.previous()+" ");
        }
        System.out.println();
        //5 4 3 2 1

        /**
        List<Integer>list3 = list2.subList(1,3);


        list3.set(0,188);
        System.out.println(list3);//一般情况下 能够直接通过sout输出
        // 引用指向对象当中的内容的时候 此时一定重写toString方法


        System.out.println(list2);
        //[1, 188, 3, 4, 5]


        /**
        //list2.remove(2);--->这样删除的是3
        //这样子就不是删下标，而是直接删除2元素
        list2.remove(new Integer(2));
        //list2.add(0,100);
        System.out.println(list2);


         */


    }


    public static void main7(String[] args) {
        ArrayList<Integer>list1 = new ArrayList<>(15);

        ArrayList<Integer>list2 = new ArrayList<>();
        list2.add(10);
        list2.add(0,100);
        System.out.println(list2);


        List<Integer> list233 = new LinkedList<>();
        list233.add(1);
        list233.add(2);
        list233.add(3);

        List<Integer>list3 = new ArrayList<>(list233);

        list3.add(1777);//默认放在数组最后一个位置
        System.out.println(list3);
    }

    public static void main2(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);

        //myArrayList.add(0,199);
        //myArrayList.add(-1,199);

        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(2));
        //System.out.println(myArrayList.get(5));
        myArrayList.set(0,999);

        myArrayList.remove(1);
        myArrayList.remove(3);

        /*
        System.out.println(myArrayList.contains(1));
        System.out.println(myArrayList.contains(10));
        System.out.println(myArrayList.indexOf(1));
        System.out.println(myArrayList.indexOf(10));
         */

        myArrayList.display();
    }
}
