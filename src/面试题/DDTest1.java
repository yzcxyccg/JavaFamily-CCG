package 面试题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author 程从广
 * @Description 设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数，现给定一正整数n，问有多少对abc和acc能满足abc+acc=n（a≠0）？
 * @Date 创建于 2020/8/21 19:46
 */
public class DDTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if(k == j || k == i || i == j) continue;
                    int sum1 = k + j * 10 + i * 100;
                    int sum2 = k + k * 10 + i * 100;
                    if ((sum1 + sum2) == n) {
                        queue.offer(sum1);
                        queue.offer(sum2);
                    }
                }
            }
        }
        count = queue.size() / 2;
        if (count == 0) {
            System.out.println(0);
        } else {
            for (int i = count; i > 0; i--) {
                System.out.println(queue.poll()+" "+queue.poll());
            }
        }
    }
}
