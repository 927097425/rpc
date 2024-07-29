package Leetcode;

public class _714 {
    public static class Solution {
        public static int maxProfit(int[] prices, int fee) {
            int len = prices.length;
            int [][] dp = new int [len][3];
            dp[0][1] = -prices[0];//持有股票时拥有的资产

            for(int i = 1;i<len;i++)
            {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-fee);//看是否需要交纳手续费
                dp[i][1] = Math.max(dp[i-1][1],dp[i][0]-prices[i]);//看是否购买股票
                dp[i][2] = Math.max(dp[i-1][2],dp[i][1]+prices[i]);//看是否卖出
            }

            return dp[len-1][2]-fee;
        }
    }
}
