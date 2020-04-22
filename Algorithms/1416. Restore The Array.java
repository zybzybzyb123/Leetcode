/**
 * 这题先用的dfs, 后来看数据量都没提交就该dp了
 * 从右往左一纬dp, 提了5次才过(整形溢出太坑了)
 */

class Solution {
    public int numberOfArrays(String s, int k) {
        char[] array = s.toCharArray();
        int n = s.length();
        int mod = 1_000_000_000 + 7;
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            // 开始用的int溢出不好处理
            long num = 0;
            if (array[i] == '0') {
                continue;
            }
            for (int j = i; j < n; j++) {
                // 这里是可能溢出的
                num = num * 10 + array[j] - '0';
                if (num > k) {
                    break;
                }
                dp[i] = (dp[i] + dp[j + 1]) % mod;
            }
        }
        return (int) (dp[0] % mod);
    }
}