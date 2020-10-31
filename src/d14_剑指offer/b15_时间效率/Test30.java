package d14_剑指offer.b15_时间效率;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 连续子数组的最大和
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2}
 * ,连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Test30 {
    /**
     * 双循环找出所有情况
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray1(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    /**
     * dp[n]代表以当前元素为截止点的连续子序列的最大和，如果dp[n-1]>0，dp[n]=dp[n]+dp[n-1]，
     * 因为当前数字加上一个正数一定会变大；如果dp[n-1]<0，dp[n]不变，因为当前数字加上一个负数
     * 一定会变小
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray2(int[] array) {
        if(array == null) throw new RuntimeException("参数错误");
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1] > 0 ? array[i - 1] : 0;
            max = Math.max(max, array[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray2(array));
    }
}
