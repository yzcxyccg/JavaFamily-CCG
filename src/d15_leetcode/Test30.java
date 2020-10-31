package d15_leetcode;

/**
 * best-time-to-buy-and-sell-stock
 * 假设你有一个数组，其中第i个元素是某只股票在第i天的价格。
 * 如果你最多只能完成一笔交易(即买一股和卖一股股票)，设计一个算法来求最大利润。
 */
public class Test30 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(prices == null || len == 0)return 0;
        int min = prices[0],max = 0;
        //遍历这个数组寻找最小值，并找到在这个最小值之后的最大值然后直接交易卖出
        for(int i = 1 ; i < len ; i++){
            min = Math.min(min,prices[i]);//最小值
            max = Math.max(max,prices[i]-min);//最大利润
        }
        return max;
    }
}
