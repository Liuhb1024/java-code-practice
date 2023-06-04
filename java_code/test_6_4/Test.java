package test_6_4;

/**
 * @author 刘浩彬
 * @date 2023/6/4
 * @deprecated String类
 */
public class Test {

    public static void main(String[] args) {
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


