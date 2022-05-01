/**
 * 状态压缩dp
 * dp[i][S]表示第i个帽子在S状态的方案数
 */

class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        int m = 1 << n;
        int mod = 1_000_000_000 + 7;
        int[][] dp = new int[41][m];
        boolean[][] vis = new boolean[n][41];
        for (int i = 0; i < hats.size(); i++) {
            for (int hat : hats.get(i)) {
                vis[i][hat] = true;
            }
        }
        // 都不戴帽子的方案为1
        dp[0][0] = 1;
        for (int i = 1; i <= 40; i++) {
            for (int j = 0; j < m; j++) {
                // 不戴帽子
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                for (int k = 0; k < n; k++) {
                    if (vis[k][i] && (j & (1 << k)) == 0) {
                        // 戴帽子累加
                        dp[i][j ^ (1 << k)] = (dp[i][j ^ (1 << k)] + dp[i - 1][j]) % mod;
                    }
                }
            }
        }
        return dp[40][m - 1];
    }
}