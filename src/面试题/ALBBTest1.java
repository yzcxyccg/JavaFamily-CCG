package 面试题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/7/29 8:45
 */
public class ALBBTest1 {
    public static int getDays(int size, int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++)
            set.add(array[i]);
        int count = 0;
        while (set.size() == size) {
            for (int i = 1; i <= size; i++) {
                set.remove(array[i-1]);
                set.add(array[i - 1] + i);
                array[i - 1] = array[i - 1] + i;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(getDays(size, array));
    }
}
