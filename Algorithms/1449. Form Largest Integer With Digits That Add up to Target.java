/**
 * dp再倒推出结果
 */

class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = cost.length - 1; i >= 0 ; i--) {
            for (int j = cost[i]; j <= target; j++) {
                if (dp[j - cost[i]] > 0) {
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + 1);
                }
            }
        }
        if (dp[target] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        int pre = target;
        for (int i = dp[target] - 1; i >= 0; i--) {
            for (int j = cost.length - 1; j >= 0; j--) {
                if (pre >= cost[j] && dp[pre - cost[j]] == i) {
                    ans.append(j + 1);
                    pre = pre - cost[j];
                    break;
                }
            }
        }
        return ans.toString();
    }
}