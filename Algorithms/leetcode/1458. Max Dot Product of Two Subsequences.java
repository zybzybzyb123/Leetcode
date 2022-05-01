/**
 * dp[i][j] = max(dp[i][j],
 *                dp[i - 1][j],
 *                dp[i][j - 1],
 *                max(nums1[i] * nums2[j], 0) + dp[i - 1][j - 1])
 * 因为非空另外还需要算只有1个的情况
 */

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i][j], Math.max(nums1[i - 1] * nums2[j - 1], 0) + dp[i - 1][j - 1]);
                ans = Math.max(ans, nums1[i - 1] * nums2[j - 1]);
            }
        }
        return dp[n][m] > 0 ? dp[n][m] : ans;
    }
}