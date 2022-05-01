/**
 * dp模板题,因为只依赖前一个位置,可以用滚动数组优化空间
 */

class Solution {
    public int countVowelPermutation(int n) {
        int MOD = 1_000_000_000 + 7;
        //滚动数组,映射到0和1
        long[][] dp = new long[2][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int cur = i % 2, pre = 1 - cur;
            dp[cur][0] = (dp[pre][1] + dp[pre][2] + dp[pre][4]) % MOD;
            dp[cur][1] = (dp[pre][0] + dp[pre][2]) % MOD;
            dp[cur][2] = (dp[pre][1] + dp[pre][3]) % MOD;
            dp[cur][3] = (dp[pre][2]) % MOD;
            dp[cur][4] = (dp[pre][2] + dp[pre][3]) % MOD;
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (int) ((ans + dp[(n - 1) % 2][i]) % MOD);
        }
        return ans;
    }
}