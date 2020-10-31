package 面试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/9/6 20:14
 */
public class TXTest9 {
    public static void midNum(int[] array1,int[]array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array1[i] < array[n / 2]) {
                System.out.println(array[n/2]);
            }else {
                System.out.println(array[n/2-1]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            array[i] = a;
            array1[i] = a;
        }
        Arrays.sort(array);
        midNum(array1,array);
    }
}
