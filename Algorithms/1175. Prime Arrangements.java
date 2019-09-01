/**
 * 计算出素数的个数,然后就是两个排列组合相乘
 */
class Solution {
    private static final int MOD = 1000000000 + 7;
    private boolean isPrim(int n) {
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int numPrimeArrangements(int n) {
        int cnt = 0;
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            if (isPrim(i)) {
                cnt++;
            }
        }
        for (int i = cnt; i > 1 ; i--) {
            ans = ans * i % MOD;
        }
        for (int i = n - cnt; i > 1 ; i--) {
            ans = ans * i % MOD;
        }
        return (int) (ans % MOD);
    }
}