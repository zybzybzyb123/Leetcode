/**
 * 下班途中突然就想出来，经典的区间dp题
 * dp数组表示区间【l,r】的最大长度
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        char[] array = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (array[i] == array[j]) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (i == j - 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}