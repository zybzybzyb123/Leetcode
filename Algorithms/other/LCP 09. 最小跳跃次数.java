/**
 * 从后往前计算, 详细见代码注释
 */

class Solution {

    public int minJump(int[] jump) {
        int n = jump.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = i + jump[i] >= n ? 1 : dp[i + jump[i]] + 1;
            int len = Math.min(n, i + jump[i]);
            // 如果dp[j] <= dp[i],直接结束.因为肯定在遍历到j的时候的值比这个优(j比i先处理)
            for (int j = i + 1; j < len && dp[j] >= dp[i] + 1; j++) {
                // 选择跳到i,通过i到达最右边
                dp[j] = dp[i] + 1;
            }
        }
        return dp[0];
    }
}