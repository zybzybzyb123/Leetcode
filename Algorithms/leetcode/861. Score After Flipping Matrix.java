/**
 * 这个题的关键就是你要知道最后第一列肯定都是1，
 * 所以就有两种情况，第1列经过切换或者没有不切换
 * 如果没有切换那么第一列为0的那一行就要切换
 * 之后每一列都统计和第一列相同或者不同的数出现
 * 多的次数就OK了
 */
class Solution {
    public int matrixScore(int[][] A) {
        int n = A.length, m = A[0].length;
        int ans = (1 << (m - 1)) * n;
        for (int j = 1; j < m; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (A[i][j] == A[i][0]) {
                    cnt++;
                }
            }
            ans += (1 << (m - 1 - j)) * Math.max(cnt, n - cnt);
        }
        return ans;
    }
}