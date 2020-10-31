package d15_leetcode;

/**
 * best-time-to-buy-and-sell-stock-ii
 * 假设你有一个数组，其中第i个元素表示某只股票在第i天的价格。设计一个算法来寻找最大的利润。你可以完成
 * 任意数量的交易(例如，多次购买和出售股票的一股)。但是，你不能同时进行多个交易(即，你必须在再次购买之前卖出之前买的股票)。
 */
public class Test29 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(prices == null || len == 0)return 0;
        int max = 0;
        for(int i = 1 ; i < len ; i++){
            if(prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }
}
