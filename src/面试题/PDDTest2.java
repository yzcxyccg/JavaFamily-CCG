package 面试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/8/2 19:30
 */
class Nod {
    int hot;
    int delicious;
}

public class PDDTest2 {
    public static int dinner() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt(), T = scanner.nextInt();
        if (T <= 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        ArrayList<Nod> list1 = new ArrayList<>();
        ArrayList<Nod> list2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            Nod nod = new Nod();
            nod.hot = x;
            nod.delicious = y;
            if (y >= T) {
                result = Math.min(result, x);
            }
            list1.add(nod);
        }
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            Nod nod = new Nod();
            nod.hot = x;
            nod.delicious = y;
            if (y >= T) {
                result = Math.min(result, x);
            }
            list2.add(nod);
        }
        for (int i = 0; i < N; i++) {
            Nod n1 = list1.get(i);
            for (int j = 0; j < M; j++) {
                Nod n2 = list2.get(j);
                int count = n1.delicious + n2.delicious;
                if (count >= T) {
                    result = Math.min(result, n1.hot + n2.hot);
                }
            }
        }
        return result == Integer.MAX_VALUE ?-1:result;
    }

    public static void main(String[] args) {
        System.out.println(dinner());
    }
}
