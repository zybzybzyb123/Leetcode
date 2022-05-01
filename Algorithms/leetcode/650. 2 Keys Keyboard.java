/**
 * 每个n依赖他的最大因数
 */

class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int[] dp = new int[n + 1];
        //初始化
        for(int i = 2; i <= n; i++){
            dp[i] = i;
        }
        for(int i = 2; i <= n; i++){
            //用前半部分会快一点
            for(int j = 2; j * j <= i; j++){
                if(i % j == 0){
                    dp[i] = dp[i / j] + j;
                    break;
                }
            }
        }
        return dp[n];
    }
}