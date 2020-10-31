package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/7/29 8:45
 */
public class ALBBTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]array = new int[n-1];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            array[i] = scanner.nextInt();
            count += array[i];
        }
        System.out.println(count-1);
    }
}
