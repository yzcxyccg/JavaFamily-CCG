package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description n个数字，所有组成数字中能整除90的最大数字
 * @Date 创建于 2020/9/3 19:03
 */
public class BDTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num_5 = 0, num_0 = 0;
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            if(m == 5) num_5++;
            if(m==0) num_0++;
        }
        if (num_5 >= 9 && num_0 >= 1) {
            num_5 -= num_5 % 9;
            while (num_5-- > 0) {
                System.out.print(5);
            }
            while (num_0-- > 0) {
                System.out.print(0);
            }
            System.out.println();
        }else System.out.println(-1);
    }
}
