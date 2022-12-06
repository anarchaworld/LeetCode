class Solution {
    public int maxProfit(int[] prices, int fee) {
        //dp[n][0] = Max(dp[n-1][0], dp[n-1][1]+prices[i]-2)
        //dp[n][1] = Max(dp[n-1][1], dp[n-1][0]-prices[i])
        //0 == not holding, 1 == holding
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < dp.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
