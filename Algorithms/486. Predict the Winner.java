/**
 * 看了题解还是觉得这种写法相比较而言比较好理解
 * dp[i][j]表示在i-j区间play1比play2多的数
 * 对于i==j dp[i][j] = nums[i]
 */
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i][i] = nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j],
                        nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}