package d14_剑指offer.b17_知识迁移能力;

import java.util.ArrayList;

/**
 * 和为S的两个数
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出
 */

public class Test42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array.length < 2)return result;
        int start = 0,end = array.length-1;
        while(start<end){
            int current = array[start]+array[end];
            if(current == sum){
                result.add(array[start]);
                result.add(array[end]);
                break;
            }else if(current < sum)
                start++;
            else end--;
        }
        return result;
    }
}
