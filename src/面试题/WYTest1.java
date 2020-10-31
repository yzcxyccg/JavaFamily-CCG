package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description 网易
 * @Date 创建于 2020/8/8 15:14
 */
public class WYTest1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 0) {System.out.println(0);return;};
        int array[] = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            count += array[i] / 2;
        }
        System.out.println(count);
    }

}
