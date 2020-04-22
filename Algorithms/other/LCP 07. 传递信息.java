/**
 * dfs
 * 可以用矩阵快速幂计算可达矩阵
 */

class Solution {
    private int dfs(int cur, boolean[][] vis, int k) {
        if (k == 0) {
            return cur == vis.length - 1 ? 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < vis[cur].length; i++) {
            if (vis[cur][i]) {
                ans += dfs(i, vis, k - 1);
            }
        }
        return ans;
    }
    public int numWays(int n, int[][] relation, int k) {
        boolean[][] vis = new boolean[n][n];
        for (int[] edge : relation) {
            vis[edge[0]][edge[1]] = true;
        }
        return dfs(0, vis, k);
    }
}