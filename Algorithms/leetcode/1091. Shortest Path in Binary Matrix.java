/**
 * 好久没写这个手生了，比赛之后又搞了十几分钟才写好，这就是一个模板
 */

class Solution {
    int[][] dir = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[] vis = new boolean[10005];
        int len = grid.length;
        if(grid[0][0] == 1 || grid[len - 1][len - 1] == 1) {
            return -1;
        }
        vis[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 1, leftNum = 1, cur = 0;
        while (!queue.isEmpty()) {
            leftNum--;
            int node = queue.poll();
            int x = node / 100, y = node % 100;
            if (x == grid.length - 1 && y == grid.length - 1) {
                return level;
            }
            for (int i = 0; i < dir.length; i++) {
                int x1 = x + dir[i][0];
                int y1 = y + dir[i][1];
                if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid.length && grid[x1][y1] ==
                        0 && !vis[x1 * 100 + y1]) {
                    vis[x1 * 100 + y1] = true;
                    queue.offer(x1 * 100 + y1);
                    cur++;
                }
            }
            if (leftNum == 0 && cur > 0) {
                level++;
                leftNum = cur;
                cur = 0;
            }
        }
        return -1;
    }
}