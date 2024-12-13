package Exam.Day1;

/**
 * @author 刘浩彬
 * @date 2023/9/22
 */
import java.util.Arrays;

import static java.util.Arrays.*;

import java.util.Scanner;


import java.util.Arrays;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[]levels = new int[3*n];
        for(int i = 0; i < 3 * n; i++){
            levels[i] = scanner.nextInt();
        }

        Arrays.sort(levels);
        long totalSum = 0;
        for(int i = levels.length / 3; i < levels.length; i += 2){
            totalSum += levels[i];
        }
        System.out.println(totalSum);
        scanner.close();
    }
}