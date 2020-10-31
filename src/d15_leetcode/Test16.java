package d15_leetcode;

import java.util.Arrays;

/**
 * candy
 * 有N个小朋友站在一排，每个小朋友都有一个评分,你现在要按以下的规则给孩子们分糖果：
 * 每个小朋友至少要分得一颗糖果,分数高的小朋友要他比旁边得分低的小朋友分得的糖果多
 * 你最少要分发多少颗糖果？
 */
public class Test16 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(ratings == null || len == 0)return 0;
        if(len == 1)return 1;
        int candy[] = new int[len];
        Arrays.fill(candy,1);
        for(int i = 1 ; i < len ; i++){
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;
        }
        int result = candy[len-1];
        for(int i = len-2 ; i >= 0 ; i--){
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1])
                candy[i] = candy[i+1]+1;
            result += candy[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int []arr = {1,3,5};
        Test16 test16 = new Test16();
        System.out.println(test16.candy(arr));
    }
}
