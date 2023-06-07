package test_6_6;

/**
 * @author 刘浩彬
 * @date 2023/6/6
 */
public class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abcd");
        System.out.println(stringBuilder);
        stringBuilder.append(1);
        stringBuilder.append("po");
        stringBuilder.append("abcd").append(12.5);
        System.out.println(stringBuilder);
        /**
         * 输出：
         * abcd
         * abcd1poabcd12.5
         * ===========================================================
         * String是不可变的对象，StringBuilder 和StringBuffer是可变的
         * ===========================================================
         */

        stringBuilder.setCharAt(0,'k');
        System.out.println(stringBuilder);

        stringBuilder.insert(1,"00000000000000000000");
        System.out.println(stringBuilder);

        //反转
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        //输出：5.21dcbaop1dcb00000000000000000000k

        String str = stringBuilder.toString();
        System.out.println(str);

        //不考虑并发的话 就使用 StringBuilder
    }
}
