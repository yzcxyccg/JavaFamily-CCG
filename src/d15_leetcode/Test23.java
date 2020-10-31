package d15_leetcode;

import java.util.TreeSet;

/**
 * longest-consecutive-sequence
 * 题目描述:给定一个无序的整数类型数组，求最长的连续元素序列的长度。
 * 例如：给出的数组为[100, 4, 200, 1, 3, 2],最长的连续元素序列为[1, 2, 3, 4]. 返回这个序列的长度：4
 * 你需要给出时间复杂度在O（n）之内的算法
 */
public class Test23 {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0)return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int n : num)set.add(n);
        int max = 1;
        for(int n : num){
            if(set.remove(n)){
                int val_small = n - 1;
                int val_big = n + 1;
                int sum = 1;
                while(set.remove(val_small)){
                    sum++;
                    val_small--;
                }
                while(set.remove(val_big)){
                    sum++;
                    val_big++;
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}
