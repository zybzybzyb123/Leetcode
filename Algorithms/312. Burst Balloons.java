/**
 * O(N^3)的动态规划
 * dp[i][j] = max(dp[i][k] + dp[k][j] + nums[k] * nums[k - 1] * nums[k + 1])
 */

class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = j; k >= i; k--) {
                    int left = (i == 0 ? 1 : nums[i - 1]);
                    int right = (j == nums.length - 1 ? 1 : nums[j + 1]);
                    int ans = left * nums[k] * right;
                    if (k >= i + 1) {
                        ans += dp[i][k - 1];
                    }
                    if (k <= j - 1) {
                        ans += dp[k + 1][j];
                    }
                    dp[i][j] = Math.max(dp[i][j], ans);
                }
            }
        }
        return dp[0][n - 1];
    }
}