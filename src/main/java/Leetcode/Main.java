package Leetcode;

import java.io.IOException;

class Solution {

    public int numOfArrays(int n, int m, int k) {
        if (m < k) {
            return 0;
        }
        int mod = 1_000_000_007;
        long[][][] dp = new long[n + 1][m + 1][k + 2];
        for (int i = 1; i <= m; i++) {
            dp[0][i][1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 1; l <= m; l++) {
                    for (int p = 1; p < l; p++) {
                        dp[i + 1][l][j + 1] = (dp[i + 1][l][j] + dp[i][p][j]) % mod;
                    }
                    dp[i + 1][l][j + 1] = (dp[i + 1][l][j] + l * dp[i][l][j + 1]) % mod;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[n][i][k]) % mod;
        }
        return (int) (ans);
    }
}

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // FileInputStream file = new FileInputStream('in.txt');
        // System.setIn(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
        Solution solution = new Solution();
        int[] nums = {10,2,-10,5,20};
        int k = 2;
        System.out.println(solution);
    }
}
