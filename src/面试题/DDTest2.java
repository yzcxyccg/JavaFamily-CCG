package 面试题;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author 程从广
 * @Description 斐波那契蛇
 * @Date 创建于 2020/8/21 20:34
 */
public class DDTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        int a =1 , b = 2;
        stack.add(1);stack.add(1);
        stack.add(2);
        for (int i = 0; i < n * n - 3; i++) {
            b = a + b;
            a = b - a;
            stack.add(b);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; j++) {
                System.out.println(stack.pop()+" ");
            }
        }
    }
}
