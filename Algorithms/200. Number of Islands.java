/**
 * 种子填充模板题
 */

class Solution {
    private int[][] dirs  =  {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(int x, int y, char[][] grid) {
        grid[x][y] = '0';
        for (int[] dir : dirs) {
            int rx = x + dir[0];
            int ry = y + dir[1];
            if (rx >= 0 && rx < grid.length
                    && ry >= 0 && ry < grid[rx].length
                    && grid[rx][ry] == '1') {
                dfs(rx, ry, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
}