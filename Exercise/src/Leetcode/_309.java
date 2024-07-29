package Leetcode;

public class _309 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int [][] dp = new int [len][3];
        dp[0][1] = -prices[0];//持有股票初始化
        for(int i = 1;i<len;i++)
        {

            dp[i][0] = Math.max(dp[i-1][2],dp[i-1][0]);//缓存状态，表示了一天冷冻期，如果赚了才进入缓存
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);//买入股票
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);//卖出股票
        }
        return dp[len-1][2];
    }

}
