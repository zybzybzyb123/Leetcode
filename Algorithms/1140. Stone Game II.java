/**
 * 比较经典的dp,看了讨论区才解决,过段时间再试试
 */

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = piles[i] + sum[i + 1];
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 2 * j && i + k <= n; k++) {
                    dp[i][j] = Math.max(dp[i][j], sum[i] - dp[i + k][Math.max(j, k)]);
                }
            }
        }
        return dp[0][1];
    }
}