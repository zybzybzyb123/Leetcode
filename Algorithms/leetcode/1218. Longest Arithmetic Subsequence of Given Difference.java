/**
 * 映射到0-20000
 * dp[i]表示以i结尾的最大长度
 */

class Solution {
    private static final int BASE = 10000;

    public int longestSubsequence(int[] arr, int difference) {
        if (arr.length == 1) {
            return 1;
        }
        int[] dp = new int[2 * BASE + 1];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i] + BASE, pre = cur - difference;
            //这种情况是1,之前continue了一直ac不了
            if (pre < 0 || pre > 2 * BASE) {
                dp[cur] = 1;
            } else {
                dp[cur] = Math.max(dp[cur], dp[pre] + 1);
            }
            ans = Math.max(ans, dp[cur]);
        }
        return ans;
    }
}