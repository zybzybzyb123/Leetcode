/**
 * 别忘记[0,0]也要计算
 */

class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int dfs(int r, int c, int k, boolean[][] vis) {
        vis[r][c] = true;
        int m = vis.length;
        int n = vis[0].length;
        int ans = 1;
        for (int i = 0; i < dirs.length; i++) {
            int rx = r + dirs[i][0];
            int ry = c + dirs[i][1];
            if (rx >= 0 && rx < m && ry >= 0 && ry < n && !vis[rx][ry]) {
                int curK = rx / 10 + rx % 10 + ry / 10 + ry % 10;
                if (curK > k) {
                    continue;
                }
                ans += dfs(rx, ry, k, vis);
            }
        }
        return ans;
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        return dfs(0, 0, k, vis);
    }
}