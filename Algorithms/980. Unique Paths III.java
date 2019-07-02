/**
 * 带深度的dfs解法，记得判重
 */

class Solution {
    private int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] vis = new boolean[25][25];
    private int dfs(int[][] grid, int src, int des, int cur, int cnt) {
        if (cur >= cnt) {
//            System.out.printf("src=%d,des=%d,cur=%d,cnt=%d\n", src,des,cur,cnt);
            return src == des ? 1 : 0;
        }
        int ans = 0;
        int x = src / 25;
        int y = src % 25;
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length
                    && !vis[x1][y1] && grid[x1][y1] != -1) {
                vis[x1][y1] = true;
                ans += dfs(grid, x1 * 25 + y1, des, cur+1, cnt);
                vis[x1][y1] = false;
            }
        }
//        System.out.printf("src=%d,des=%d,cur=%d,cnt=%d,ans=%d\n", src,des,cur,cnt,ans);
        return ans;
    }

    public int uniquePathsIII(int[][] grid) {
        int src = -1, des = -1, cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    src = i * 25 + j;
                    vis[i][j] = true;
                } else if (grid[i][j] == 2) {
                    des = i * 25 + j;
                } else if (grid[i][j] == 0) {
                    cnt++;
                }
            }
        }
//        System.out.printf("cnt=%d\n", cnt);
        return dfs(grid, src, des, 1, cnt + 2);
    }
}