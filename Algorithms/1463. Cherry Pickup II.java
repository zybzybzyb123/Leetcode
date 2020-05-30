/**
 * 有点尴尬其实很简单然而比赛想复杂了, 以为是枚举列处理左右两半
 * (分析可知肯定不会穿过) 但是针对相交的列不好搞
 * dp[i][j][k] 表示第i行左边在j右边在k的权重
 * 记录位置就是一个普通dp, 动归还要多练习, 太弱了
 */

class Solution {
    {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n + 1][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (dp[i - 1][j][k] < 0) {
                        continue;
                    }
                    int x = dp[i - 1][j][k];
                    for (int l = Math.max(0, j - 1); l < Math.min(m, j + 2); l++) {
                        for (int o = Math.max(0, k - 1); o < Math.min(m, k + 2); o++) {
                            int step = grid[i][l] + grid[i][o];
                            if (l == o) {
                                step -= grid[i][l];
                            }
                            dp[i][l][o] = Math.max(x + step, dp[i][l][o]);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[n - 1][i][j]);
            }
        }
        return ans;
    }
}