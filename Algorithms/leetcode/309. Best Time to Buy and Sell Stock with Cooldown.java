/**
 * dp 三个状态 卖出,持有,冷冻期
 * 卖出肯定大于冷冻期的
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][1] = -prices[0];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
                dp[i][2] = dp[i - 1][0];
            }
        }
        return dp[n - 1][0];
    }
}