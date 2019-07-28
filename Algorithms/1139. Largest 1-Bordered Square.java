/**
 * 在比赛时候想到思路了，然而没啥卵用没有完成
 * 大致思路就是记录当前位置最大的横边和竖边
 * 然后找到对应端点判断是否能构成正方形
 */

class Solution {
    private int getMaxSqure(int[][] dp, int cur, int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        }
        int maxSqure = Math.min(dp[i][j] / 200, dp[i][j] % 200);
//        System.out.format("i=%d, j=%d, maxSqure=%d\n", i, j, maxSqure);
        if (maxSqure <= cur) {
            return cur;
        }
        for (int k = maxSqure; k > cur ; k--) {
            if (dp[i - k + 1][j] % 200 >= k && dp[i][j - k + 1] / 200 >= k) {
                return k;
            }
        }
        return cur;
    }

    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i][j - 1] % 200 + dp[i - 1][j] / 200 * 200 + 201;
                    } else if (i > 0) {
                        dp[i][j] = dp[i - 1][j] / 200 * 200 + 201;
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1] % 200 + 201;
                    } else {
                        dp[i][j] = 201;
                    }
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.printf("dp[%d][%d]=%d ", i, j, dp[i][j]);
//            }
//            System.out.println();
//        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(getMaxSqure(dp, ans, i, j), ans);
//                    System.out.format("i=%d, j=%d, ans=%d\n", i, j, ans);
                }
            }
        }
        return ans * ans;
    }
}