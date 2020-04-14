/**
 * 递归版本
 * dp实现(状态压缩需要每次都重新开数组,感觉没有必要)
 */
class Solution {
    // 递归
    private int findTargetSumWays(int[] nums, int cur, int sum) {
        if (cur == nums.length) {
            return sum == 0 ? 1 : 0;
        }
        int cnt1 = findTargetSumWays(nums, cur + 1, sum + nums[cur]);
        int cnt2 = findTargetSumWays(nums, cur + 1, sum - nums[cur]);
        return cnt1 + cnt2;
    }

    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    // dp
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][1000 + nums[0]] = 1;
        dp[0][1000 - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (dp[i - 1][j + 1000] > 0) {
                    dp[i][j + 1000 + nums[i]] += dp[i - 1][j + 1000];
                    dp[i][j + 1000 - nums[i]] += dp[i - 1][j + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];

    }
}