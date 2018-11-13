/**
 * 经典的种子填充，dfs的一个经典运用
 */
class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private boolean inside(int x, int y, int n, int m) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
    private int dfs(int x, int y, int[][] grid) {
        int ans = 0;
        grid[x][y] = 0;
        for (int[] point : dir) {
            int x1 = x + point[0];
            int y1 = y + point[1];
            if (inside(x1, y1, grid.length, grid[x].length) && grid[x1][y1] == 1) {
                ans += dfs(x1, y1, grid) + 1;
            }
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j, grid) + 1);
                }
            }
        }
        return ans;
    }
}