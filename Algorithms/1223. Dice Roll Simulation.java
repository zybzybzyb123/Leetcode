/**
 * 一个循环变量写错了半个多小时没有debug出来,结果周赛结束三分钟就看出来了...
 * dp[n][i][j]表示第n的以i结尾并且i出现次数为j的可能性
 * 这个可以用滚动数组优化空间
 */

class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        //滚动数组
        long[][][] dp = new long[2][6][16];
        for (int i = 0; i < 6; i++) {
            dp[0][i][1] = 1;
        }
        int mod = 1_000_000_000 + 7;
        for (int i = 1; i < n; i++) {
            int cur = i % 2, pre = 1 - cur;
            for (int j = 0; j < 6; j++) {
                //要清除之前的数
                dp[cur][j][1] = 0;
                for (int k = 0; k < 6; k++) {
                    for (int l = 1; l <= rollMax[k]; l++) {
                        if (j == k) {
                            //相同的结尾更新次数
                            if (l < rollMax[k]) {
                                dp[cur][j][l + 1] = dp[pre][k][l];
                            }
                        } else {
                            //不同的数用其他的相加
                            dp[cur][j][1] = (dp[cur][j][1] + dp[pre][k][l]) % mod;
                        }
                    }

                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= rollMax[i]; j++) {
                ans = (ans + dp[(n - 1) % 2][i][j]) % mod;
            }
        }
        return (int) (ans % mod);
    }
}