package d14_剑指offer.b5_栈和队列;

import java.util.ArrayList;

/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}
 * 及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组
 * {2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Test64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(num.length == 0 || num.length < size || size == 0)return result;
        int counts = num.length-size+1;
        for(int i = 0 ; i < counts ; i++){
            int temp = Max(num,i,size);
            result.add(temp);
        }
        return result;
    }
    public int Max(int []array,int start,int size){
        int max = 0;
        for(int i = start ; i < start+size ; i++){
            if(array[i] > max)
                max = array[i];
        }
        return max;
    }

}
