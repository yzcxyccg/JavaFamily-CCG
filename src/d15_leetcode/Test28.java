package d15_leetcode;

/**
 * best-time-to-buy-and-sell-stock-iii
 * 假设你有一个数组，其中第i个元素是某只股票在第i天的价格。设计一个算法来求最大的利润。你最多可以进行两次交易。
 * 注意:你不能同时进行多个交易(即，你必须在再次购买之前出售之前买的股票)。
 */
public class Test28 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(prices == null || len == 0)return 0;
        int[] pre = new int[len];
        int[] post = new int[len];
        int min = prices[0];
        for(int i = 1 ; i < len ; i++){
            min = Math.min(min,prices[i]);
            pre[i] = Math.max(pre[i-1],prices[i] - min);
        }
        int max = prices[len-1];
        for(int i = len - 2 ; i >= 0 ; i--){
            max = Math.max(max,prices[i]);
            post[i] = Math.max(post[i+1],max - prices[i]);
        }
        int result = 0;
        for(int i = 0 ; i < len ; i++){
            result = Math.max(result,pre[i]+post[i]);
        }
        return result;
    }
}
