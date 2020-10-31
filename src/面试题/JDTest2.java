package 面试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 程从广
 * @Description 球从入口（第一层）滚至最下面一层的最大得分和。
 * @Date 创建于 2020/8/27 19:43
 */
public class JDTest2 {
    public static int getMaxNum(ArrayList<ArrayList<Integer>> array) {
        int len = array.size();
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < array.get(i).size(); j++) {
                int max = array.get(i).get(j) + Math.max(array.get(i + 1).get(j), Math.max(array.get(i + 1).get(j + 1), array.get(i + 1).get(j + 2)));
                array.get(i).set(j, max);
            }
        }
        return array.get(0).get(0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> trangle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < 2*i-1 ; j++){
                list.add(scanner.nextInt());
            }
            trangle.add(list);
        }
        System.out.println(getMaxNum(trangle));
    }
}
