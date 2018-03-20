class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            ans += ch;
        }
        for (int i = 0; i < m; i++) {
            char ch = s2.charAt(i);
            ans += ch;
        }
        for(int i = 1; i <= s1.length(); i++){
            char ch3 = s1.charAt(i - 1);
            for(int j = 1; j <= s2.length(); j++){
                char ch4 = s2.charAt(j - 1);
                if(ch3 == ch4){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + ch4);
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return ans - dp[n][m] * 2;
    }
}