/**
 * 这个题算回溯吧,我以为是滑雪场那个dp,写了半天没写出来
 * 就是dfs,每次退出的时候更新访问标志
 */

class Solution {
    private static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int dfs(int x, int y, boolean[][] vis, int[][] grid) {
        int ans = 0, n = grid.length, m = grid[0].length;
        vis[x][y] = true;
        for (int i = 0; i < dir.length; i++) {
            int x0 = x + dir[i][0], y0 = y + dir[i][1];
            if (x0 >= 0 && x0 < n && y0 >= 0 && y0 < m && !vis[x0][y0] && grid[x0][y0] > 0) {
                ans = Math.max(dfs(x0, y0, vis, grid), ans);
            }
        }
        vis[x][y] = false;
        return ans + grid[x][y];
    }

    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    ans = Math.max(ans, dfs(i, j, vis, grid));
                }
            }
        }
        return ans;
    }
}