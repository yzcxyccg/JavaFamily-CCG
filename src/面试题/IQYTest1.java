package 面试题;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/23 15:18
 */

import java.util.Scanner;

/**
 * 正整数n的阶乘(n!)中的末尾有多少个0?例如：n = 5, n! = 120.末尾有1个0
 */
public class IQYTest1 {
    public static int getZero(int n) {
        int count = 0;
        for(int i = 2 ; i <= n ; i++){
            int j = i;
            while (j % 5 == 0) {
                j /= 5;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getZero(n));
    }
}
