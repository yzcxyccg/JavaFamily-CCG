package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description X集合中可以被特征值中的某个数Y整除，这个数就是有显著特征的数，求共有几个
 * @Date 创建于 2020/9/1 19:16
 */
public class PDDTest6 {
    public static int getCount() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt(), count = 0;
        long[] arr = new long[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextLong();
        }
        for (long i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if(i%arr[j] == 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(getCount());
    }
}
