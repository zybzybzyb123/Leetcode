/**
 * 0-1背包模板题,注意空间压缩要倒序处理
 */

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) > 0) {
            return false;
        }
        int n = nums.length;
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = m - nums[i]; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + nums[i]] = true;
                }
            }
        }
        return dp[m];
    }
}