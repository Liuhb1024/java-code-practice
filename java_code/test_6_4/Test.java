package test_6_4;

import test_4_30.oop.constructor.Student;

/**
 * @author 刘浩彬
 * @date 2023/6/4
 * @deprecated String类
 */
public class Test {

    public static void main(String[] args) {
        /**
         *      final int[]array = {1,2,3,4};
         *      array[0] = 10;
         *      array = new int[3]; ------> 报错了
         */


    }

    public static void main12(String[] args) {
        String s = "abcdef";
        //这里如果传入的是0下标 那么默认返回原来的对象
        //但是如果传入的是其他的对象 此时返回新的对象
        String ret = s.substring(1,4);//左闭右开区间
        System.out.println(ret);


        //去除左右两边空格键
        String s2 = "   abc   def   ";
        System.out.println(s2);
        System.out.println(s2.trim());
    }

    //特殊情况
    public static void main11(String[] args) {
        String str = "196.168.0.0.1";
        //String[]strings = str.split(".");
        //没有分割
        String[]strings = str.split("\\.");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        String str2 = "198\\168\\0\\0\\1";
        String[]strings2 = str2.split("\\\\");
        for (int i = 0; i < strings2.length; i++) {
            System.out.println(strings2[i]);
        }

        System.out.println("==========================================");

        String str3 = "name=zhansgan&age=10";
        String[]strings3 = str3.split("&|=");
        for (int i = 0; i < strings3.length; i++) {
            System.out.println(strings3[i]);
        }

    }

    //字符串拆分
    public static void main10(String[] args) {
        String str = "name=zhansgan&age=10";
        //分割之后的数组要存储到数组中
        String[]strings = str.split("&");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println("===========================================");
        String str2 = "hello world hello bit";
        //分成两组 第一组一个，第二组三个，没法均匀分
        String[]strings2 = str2.split(" ",2);
        for (int i = 0; i < strings2.length; i++) {
            System.out.println(strings2[i]);
        }
    }

    //字符串的替换
    public static void main9(String[] args) {
        String str = "ababcdabcdef";

        //把所有的ab替换为1111 这个替换也是一样 不是在原来的字符串进行替换 他是产生了新的对象
        String ret = str.replace("ab","1111");
        System.out.println(ret);
        System.out.println("===========================================");

        String ret1 = str.replace('b','z');
        System.out.println(ret1);
        System.out.println("===========================================");

        String ret3 = str.replaceFirst("ab","kk");
        System.out.println(ret3);//只替换第一个ab
        System.out.println("===========================================");

        String ret4 = str.replaceAll("ab","kk");
        System.out.println(ret4);//全部ab替换
    }

    //字符串转数组
    public static void main8(String[] args) {
        String str1 = "hello";
        char[] array = str1.toCharArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();

        //格式化
        String s = String.format("%d-%d-%d",2023,6,5);
        System.out.println(s);
    }

    //大小写转换
    public static void main7(String[] args) {
        String str1 = "hello";
        String ret = str1.toUpperCase();
        System.out.println(ret);
        /**
         * 在Java中 String是不可变的
         * hello -> HELLO -> 这个转换 不是在原来的字符串上面进行转换 他是生成了一个新的对象
         */
        String str2 = "HELLO";
        String ret2 = str2.toLowerCase();
        System.out.println(ret2);
    }

    //字符串转化
    public static void main6(String[] args) {
        String s1 = String.valueOf(1234);
        String s2 = String.valueOf(12.34);
        String s3 = String.valueOf(true);
        String s4 = String.valueOf(new Student("zahngsan",2));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }

    //字符串查找
    public static void main5(String[] args) {
        String str1 = "abcdef";
        //获取指定位置的字符
        char ch = str1.charAt(1);
        System.out.println(ch);
        // b

        //KMP 算法
        int index = str1.indexOf('c');
        System.out.println(index);
        // 2

        System.out.println("===========================");
        String str2 = "abcdabcdef";

        int index2 = str2.lastIndexOf('a',7);
        System.out.println(index2);
        // 6
    }


    /**
     * 字符串比较
     * 1. ==
     * 2. equals
     * 3. compareTo
     * 4. compareToIgnoreCase
     * @param args
     */

    public static void main4(String[] args) {
        String str1 = "abcd";
        String str2 = "Abcd";
        //忽视大小写 进行比较
        System.out.println(str1.compareToIgnoreCase(str2));
    }

    public static void main3(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        //System.out.println(str1 > str2); ----> 报错
        //str1 大于 str2 那么 返回正数 如果不大于 返回负数 如果相同 返回0
        System.out.println(str1.compareTo(str2));
        System.out.println(str2.compareTo(str2));
        System.out.println(str2.compareTo(str1));

        /**
         * 比较逻辑：
         * 1. 如果两个字符串的长度是一样的，那么第一个不一样的字符的大小就是整个字符
         * 2. 如果两个字符串的长度不一样，那么谁长，那么先比较两个长度的差值个
         * 3. 在这个差值范围内，有不一样的字符就能比出来大小
         * 4. 但是如果都是一样的，那么就看谁长 谁大
         */

    }

    public static void main2(String[] args) {
        String str1 = new String("abcde");
        String str2 = new String("abcde");

        System.out.println(str1 == str2);//false ---> 存的地址不一样

        System.out.println(str1.equals(str2));

        System.out.println("=============================");

        String str3 = "abcde";
        String str4 = "abcde";
        System.out.println(str3 == str4);//true ---> 字符串常量池 需要有哈希表的基础

    }

    public static void main1(String[] args) {
        String str = "hello"; //区别于C语言 Java当中的字符串 没有以\0结尾这样的说法
        System.out.println(str);
        System.out.println(str.length());//方法

        String str1 = "";
        System.out.println(str1.isEmpty());//判断字符串是不是空的

        String str2 = null;//str2这个引用 不指向任何对象
        //System.out.println(str2.isEmpty());//---->Exception in thread "main" java.lang.NullPointerException

        /*
        int []array2 = {1,2,3,4,5};
        System.out.println(array2.length);//不是方法

        String str2 = new String("world");

        char[] array ={'a','b','c'};
        String  str3 = new String(array);
        System.out.println(array);

         */

    }
}


