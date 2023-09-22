package Exam.Day1;

/**
 * @author 刘浩彬
 * @date 2023/9/22
 */
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的两个字符串
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        // 使用replace方法将str2中的每个字符替换为空字符串
        for (int i = 0; i < str2.length(); i++) {
            str1 = str1.replace(String.valueOf(str2.charAt(i)), "");
        }

        System.out.println(str1);

        scanner.close();
    }
}
