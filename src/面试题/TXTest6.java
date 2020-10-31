package 面试题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/9/6 20:04
 */
public class TXTest6 {
    public static ArrayList<Integer> getList() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        ArrayList<Integer> list = new ArrayList<>();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            if (set.contains(a)) {
                list.add(a);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = getList();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
