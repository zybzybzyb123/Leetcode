package Leetcode;

import java.io.IOException;
import java.util.Arrays;

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

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int getKth(int lo, int hi, int k) {
        return 0;
    }

    public int expectNumber(int[] scores) {
        int[] cnt = new int[1_000_001];
        int ans = 0;
        for (int score : scores) {
            if (cnt[score] == 0) {
                ans++;
                cnt[score]++;
            }
        }
        return ans;
    }

    private int calDays(int[] time, int n) {
        int ans = 0;
        for (int i = 0; i < time.length; ) {
            int sum = 0;
            int maxValue = 0;
            while (i < time.length) {
                maxValue = Math.max(maxValue, time[i]);
                if (sum + time[i] > n + maxValue) {
                    break;
                } else {
                    sum += time[i++];
                }
            }
            ans++;
        }
        return ans;
    }

    public int minTime(int[] time, int m) {
        if (m >= time.length) {
            return 0;
        }
        int left = 1;
        int right = 1_000_000_000;
        while (left <= right) {
           int mid = left + (right - left) / 2;
           int day = calDays(time, mid);
           if (day > m) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
        }
        return left;
    }
}

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // FileInputStream file = new FileInputStream('in.txt');
        // System.setIn(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
        Solution solution = new Solution();
    }
}
