package 面试题;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/22 20:08
 */
import java.util.Scanner;

/**
 * 给定一个1到N的排列P1到PN（N为偶数），初始时Pi=i（1≤i≤N），现在要对排列进行M次操作，每次操作为以下两种中一种：
 * ①将排列的第1个数移到末尾；
 * ②交换排列的第1个数与第2个数、第3个数与第4个数、...、第N-1个数与第N个数。
 * 求经过这M次操作后得到的排列。
 */
public class 三六零Test2 {
    public static void cz1(int[] array) {
        int a = array[0];
        for (int i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[array.length - 1] = a;
    }

    public static void cz2(int[] array) {
        for (int i = 0; i < array.length; i +=2 ) {
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i+1;
        }
        for (int i = 0; i < m; i++) {
            int j = scanner.nextInt();
            if(j == 1) cz1(array);
            else if(j == 2) cz2(array);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
