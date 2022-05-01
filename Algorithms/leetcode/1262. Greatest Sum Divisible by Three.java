/**
 * 很明显的数位dp, 比赛的时候看出来了去搞最后一题了
 * 关键是最后一题现在还没过...
 * dp[i][j]表示前i个数以j结尾的最大值
 * 用个简单的滚动数组优化空间
 */

class Solution {
    public int maxSumDivThree(int[] nums) {
        //简单的滚动数组
        int[][] dp = new int[2][3];
        for (int i = 0; i < nums.length; i++) {
            int cur = (i + 1) % 2, pre = 1 - cur;
            dp[cur][0] = dp[pre][0];
            dp[cur][1] = dp[pre][1];
            dp[cur][2] = dp[pre][2];
            for (int j = 0; j < 3; j++) {
                int pos = (dp[pre][j] + nums[i]) % 3;
                dp[cur][pos] = Math.max(dp[cur][pos], dp[pre][j] + nums[i]);
            }
        }
        return dp[nums.length % 2][0];
    }
}