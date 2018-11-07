/**
 * 经典题了，就不多说了，在leetcode用stream真的
 * 特别特别的慢
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 1) return A[0][0];
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                } else if (j == A.length - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + A[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]), dp[i - 1][j])  +
                            A[i][j];
                }
            }
        }
        return Arrays.stream(dp[A.length - 1]).min().getAsInt();
    }
}