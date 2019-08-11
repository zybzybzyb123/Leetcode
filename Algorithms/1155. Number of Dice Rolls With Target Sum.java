/**
 * dp难得想出来了，结果短路了转移的时候脑子抽了想错了
 * 一个小时没有调出来吗，还是要多练啊，太菜了
 */

class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) {
            return 0;
        }
        int mod = 1000000007;
        //dp[i][j]表示丢j次骰子达到i的组合数
        long[][] dp = new long[target + 1][d + 1];
        for (int i = 1; i <= f && i <= target; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 2; j <= d ; j++) {
                for (int k = 1; k <= f && k <= i; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - k][j - 1] % mod);
                }
            }
        }
        return (int) (dp[target][d] % mod);
    }
}