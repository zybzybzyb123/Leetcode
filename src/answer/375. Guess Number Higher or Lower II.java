class Solution {
    public int getMoneyAmount(int n) {
        if(n == 1) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 1; i--){
            for(int j = i + 1; j <= n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(k - 1 > i ? dp[i][k - 1] : 0, k + 1 < j ? dp[k + 1][j] : 0) + k);
                }
            }
        }
        return dp[1][n];
    }
}