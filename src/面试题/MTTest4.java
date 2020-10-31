package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/8 16:20
 */
public class MTTest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result1 = 0,result2 = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            if (x < y) {
                result1 += y;
            } else {
                result1 += x;
                result2 += (x - y);
            }
        }
        System.out.println(result1+" "+result2);
    }
}
