package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description 两个整数N、M,分别是商品总数、背包原始大小，N行每行两个数ci、cv分别是占用背包空间（负数增加空间）、收益多少，
 * @Date 创建于 2020/9/1 19:16
 */

/**
 * 01背包问题
 * 5 10
 * 2 6
 * 2 3
 * 6 5
 * 5 4
 * 4 6
 */
public class PDDTest5 {
    int N, V;
    private int[] weignt;
    private int[] value;
    private int[] MaxV;
    public int getMaxV() {
        MaxV[0] = 0;
        for (int i = 1; i <= V; i++) {
            MaxV[i] = 0;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                if (j >= weignt[i]) {
                    MaxV[j] = Math.max(MaxV[j - weignt[i]] + value[i], MaxV[j]);
                    max = Math.max(MaxV[j], max);
                }
            }
        }
        return max;
    }
    public  void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        V = scanner.nextInt();
        weignt = new int[N];
        value = new int[N];
        MaxV = new int[V + 1];
        for (int i = 0; i < N; i++) {
            weignt[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
    }
    public static void main(String[] args) {
        PDDTest5 pddTest5 = new PDDTest5();
        pddTest5.init();
        System.out.println(pddTest5.getMaxV());
    }
}
