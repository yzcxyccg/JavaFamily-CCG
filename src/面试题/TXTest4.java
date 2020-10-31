package 面试题;

import java.util.Scanner;

/**
 * @author 程从广
 * @Description 数字之和
 * @Date 创建于 2020/8/23 20:49
 */
public class TXTest4 {
    public static int getMax(int[] n) {
        int len = n.length;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (n[i] == 9 || i == len-1) {
                arr1[i] = n[i] / 2;
                arr2[i] = n[i] - arr1[i];
            }else{
                arr1[i] = (n[i] + 10) / 2;
                arr2[i] = (n[i] + 10) - arr1[i];
                n[i + 1] = n[i + 1] - 1;
            }
            sum +=(arr1[i]+arr2[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String n = scanner.next();
            StringBuffer sb = new StringBuffer(n);
            String str = sb.reverse().toString();
            int []array = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                array[j] = Integer.valueOf(str.substring(j, j + 1));
            }
            System.out.println(getMax(array));
        }
    }
}
