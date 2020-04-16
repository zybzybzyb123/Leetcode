/**
 * 常规dp,把三种颜色看成一体,其实可以看作递推
 */

class Solution {
    public int numOfWays(int n) {
        long[][] dp = new long[n][27];
        int mod = 1_000_000_000 + 7;
        for (int i = 0; i < 27; i++) {
            if (!isSameColor(i)) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                if (!isSameColor(j)) {
                    for (int k = 0; k < 27; k++) {
                        if (!isSameColor(k) && !isSameColor(j, k)) {
                            dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                        }
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 27; i++) {
            if (!isSameColor(i)) {
                ans = (ans + dp[n - 1][i] % mod) % mod;
            }
        }
        return (int) ans;
    }

    private boolean isSameColor(int num) {
        int a = num / 9;
        int b = num / 3 % 3;
        int c = num % 3;
        return a == b || b == c;
    }

    private boolean isSameColor(int num1, int num2) {
        if (num1 / 9 == num2 / 9) {
            return true;
        }
        if (num1 / 3 % 3 == num2 / 3 % 3) {
            return true;
        }
        if (num1 % 3 == num2 % 3) {
            return true;
        }
        return false;
    }
}