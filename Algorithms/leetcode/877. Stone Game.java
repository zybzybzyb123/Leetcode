/**
 * 昨天脑袋短路了，居然dp卡住了，这是一道经典题
 * dp表示甲比乙多赢的分数，
 * dp[i][j] = Math.min(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1] )
 * 表示从左取或者从右取，相减是因为轮到下一个人了
 *
 * 另外针对本题可以判断先手必胜，因为甲可以取到所有奇数号或者所有偶数号的组合
 * 只要取这两个组合中大的就可以实现必胜
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = piles.length - 1; i >= 0; i--) {
            for (int j = i; j < piles.length; j++) {
                if (i == j) {
                    dp[i][j] = piles[i];
                } else {
                    dp[i][j] = Math.min(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1] );
                }
            }
        }
        return dp[0][piles.length - 1] > 0;
    }
}