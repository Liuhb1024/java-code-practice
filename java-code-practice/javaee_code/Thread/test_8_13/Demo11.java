package Thread.test_8_13;

/**
 * @author 刘浩彬
 * @date 2023/9/15
 */

//证明sleep(1000)实际上并不精确

public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        /*
        System.out.println("开始： " + System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println("结束： " + System.currentTimeMillis());
         */
        long beg = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - beg) + "ms");

    }
}
