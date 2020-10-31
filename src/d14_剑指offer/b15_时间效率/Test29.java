package d14_剑指offer.b15_时间效率;

import java.util.ArrayList;

/**
 * 最小k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Test29 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k < 1 || input.length < k) return list;
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[minIndex] > input[j])
                    minIndex = j;
            }
            if(minIndex != i) {
                input[minIndex] = input[minIndex] ^ input[i];
                input[i] = input[minIndex] ^ input[i];
                input[minIndex] = input[minIndex] ^ input[i];
            }
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(array,8));
    }
}
