/**
 * dp
 * 直接贪心法计算, 因为硬币给的比较特殊(枚举用5元硬币的可能性)
 */

class Solution {

    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        long[] dp = new long[n + 1];
        int mod = 1_000_000_000 + 7;
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = 0; i <= n - coin; i++) {
                if (dp[i] > 0) {
                    dp[i + coin] = (dp[i + coin] + dp[i]) % mod;
                }
            }
        }
        return (int) (dp[n]);
    }
}