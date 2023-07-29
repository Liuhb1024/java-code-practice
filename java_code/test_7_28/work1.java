package test_7_28;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 刘浩彬
 * @date 2023/7/28
 */
public class work1 {
    //获取一个二进制序列中的所有偶数位和奇数位，分别输出二进制序列
    //eg:2的二进制序列位10 偶数位：1 奇数位：0
    //   4的二进制序列位100 偶数位：0 奇数位：1 0
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int []arr=new int[16];//用于存放奇数位，一个数32位，奇/偶数位最高16位
        int []brr=new int [16];//用于存放偶数位
        int i=0;
        int j=0;
        int k=0;
        for(i=1;i<=32;i++)//获取输入数的末位数字
        {
            if(i%2!=0)//奇数位
            {
                arr[j]=n&1;
                //比如n=1010，n&1
                //   1=0001
                // n&1=0000=0，获取到了n的末位
                j++;
                n>>>=1;//无符号右移
            }
            else
            {
                brr[k]=n&1;
                k++;
                n>>>=1;
            }
        }
        System.out.println("现打印奇数位：");
        for(i=0;i<16;i++)
        {
            System.out.print(arr[15-i]+" ");
        }
        System.out.println();
        System.out.println("现打印偶数位：");
        for(i=0;i<16;i++)
        {
            System.out.print(brr[15-i]+" ");
        }
    }

    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //0000 0010
        for (int i = 31; i >= 1 ; i-=2) {
            System.out.print(((n>>>i) & 1) + " " );
        }
        System.out.println();
        for (int i = 30; i >= 0 ; i-=2) {
            System.out.print(((n>>>i) & 1) + " " );
        }
    }

    /**
     * 求2个整数的最大公约数
     * 给定两个数，求这两个数的最大公约数
     * 例如：
     * 输入：20 40
     *
     * 输出：20
     * @param args
     */
    public static void main7(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入两个数字：>");
        int a = sc1.nextInt();
        int b = sc2.nextInt();
        int c = a % b;
        while(c != 0){
            a = b;
            b = c;
            c =a % b ;
        }
        System.out.println(b);
    }

    /**
     * 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,
     * 密码错误， 可以重新输 入，最多输入三次。三次均错，则提示退出程序
     */
    public static void main6(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 3;
        while (count != 0){
            System.out.println("请输入您的密码：>");
            String password = sc.nextLine();
            if(password.equals("123")){
                System.out.println("登陆成功！");
                break;
            }else {
                count--;
                System.out.println("请重新输入密码:> 还有"+count+"次机会");
            }
        }
    }



    /**
     * 输出一个整数的每一位
     * 输出一个整数的每一位，如：123的每一位是3，2，1
     */
    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num != 0){
            System.out.println(num%10);
            num/=10;
        }
    }

    /**
     * KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的X形图案。
     * 输入描述：
     * 多组输入，一个整数（2~20），表示输出的行数，也表示组成“X”的反斜线和正斜线的长度。
     * 输出描述：
     * 针对每行输入，输出用“*”组成的X形图案。
     * 输入：
     * 5
     * 复制
     * 输出：
     * *   *
     *  * *
     *   *
     *  * *
     * *   *
     */
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || i + j == n - 1) {
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
            break;
        }

    }


    /**
     * 实现猜数字游戏
     * 完成猜数字游戏   ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序。
     */

    public static void main3(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int guess = random.nextInt(100);
        while(true){
            System.out.println("请输入0-100的数字：>");
            int num = sc.nextInt();
            if(num < guess){
                System.out.println("猜小了");
            }else if(num > guess){
                System.out.println("猜大了");
            }else {
                System.out.println("猜对了！");
                break;
            }
        }
        sc.close();
    }




    /**
     * 计算分数的值
     * 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
     */
    public static void main2(String[] args) {
        double sum = 0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            sum += 1.0 / i * flag;
            flag = -flag;
        }
        System.out.println(sum);
    }



/**
 * 数字9 出现的次数
 * 编写程序数一下 1到 100 的所有整数中出现多少个数字9
 */
    public static void main1(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 10 == 9){
                count++;
            }
            if(i / 10 == 9){
                count++;
            }
        }
        System.out.println(count);
    }
}
