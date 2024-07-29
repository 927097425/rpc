package Leetcode;

public class _188 {
    public static class Solution {
        public static int maxProfit(int k, int[] prices) {
            int n = prices.length;
            int [][] dp = new int[n][2*k];

            //初始化
            for(int j = 0;j<k;j++)
            {
                dp[0][2*j] = -prices[0];//第k次持有股票
                dp[0][2*j+1] = 0;//第k次不持有股票
            }

            for(int i = 1;i<n;i++)
            {
                for(int j=0;j<k;j++)//更新第j次第i天的结果
                {
                    int last_prices = 0;
                    if(j != 0) last_prices = dp[i-1][2*j-1];
                    dp[i][2*j] = Math.max(dp[i-1][2*j],last_prices-prices[i]);//第j次持有股票
                    dp[i][2*j+1] = Math.max(dp[i-1][2*j+1],dp[i-1][2*j]+prices[i]);//第j次不持有股票
                }
            }
            return dp[n-1][2*k-1];
        }
    }
}
