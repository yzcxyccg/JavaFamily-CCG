package 面试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/8 16:47
 */

public class MTTest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int count = 0;
        int sign = 0;
        for (int j = 1; j <= 100; j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) == j && list.get(i) == list.get(i + 1)) {
                    list.remove(i);
                    list.remove(i + 1);
                    list.add(i, (list.get(i) + 1));
                    i = -1;
                    count++;
                    sign = 1;
                }
                if (i == list.size() - 2 && sign == 1) {
                    i = -1;
                    sign = 0;
                }
            }
        }
        System.out.println(count);
    }
}
