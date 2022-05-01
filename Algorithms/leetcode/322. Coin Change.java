/**
 * 经典dp
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= amount - coins[i]; j++) {
                if (dp[j] != -1) {
                    if (dp[j + coins[i]] == -1) {
                        dp[j + coins[i]] = dp[j] + 1;
                    } else {
                        dp[j + coins[i]] = Math.min(dp[j + coins[i]], dp[j] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }
}