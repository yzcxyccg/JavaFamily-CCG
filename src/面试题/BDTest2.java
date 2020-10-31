package 面试题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description 优质奶牛
 * @Date 创建于 2020/9/3 19:12
 */
public class BDTest2 {
    public static void getResult() {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        for (int b = 0; b < sum; b++) {
            int n = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i, 0);
            }
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                int k = scanner.nextInt();
                for (int j = 0; j < k; j++) {
                    int l = scanner.nextInt(), r = scanner.nextInt();
                    while (l <= r) {
                        map.put(l, map.get(l) + 1);
                        l++;
                    }
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= map.size(); i++) {
                if (map.get(i) == m) {
                    list.add(i);
                }
            }
            System.out.println(list.size());
            list.stream().forEach(l -> {
                System.out.print(l + " ");
            });
        }
    }
    public static void main(String[] args) {

     getResult();
    }
}
