package 面试题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/9/6 20:14
 */
public class TXTest7 {
    public static void getSize(ArrayList<HashSet<Integer>> list) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        set.add(0);
        queue.add(0);
        while (queue.size() != 0) {
            int m = queue.poll();
            for (int i = 0; i < list.size(); i++) {
                HashSet<Integer> set1 = list.get(i);
                if (set1.contains(m)) {
                    set1.stream().forEach(s->{
                        if(!set.contains(s)){
                            set.add(s);
                            queue.add(s);
                        }
                    });
                }
            }
        }
        System.out.println(set.size());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int sum = scanner.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < sum; j++) {
                set.add(scanner.nextInt());
            }
            list.add(set);
        }
        getSize(list);
    }
}
