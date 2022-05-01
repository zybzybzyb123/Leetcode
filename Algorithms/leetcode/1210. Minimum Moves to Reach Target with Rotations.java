/**
 * 这道题我周赛就看出来(bfs简单变形),当时感觉时间不够就没写
 * 没想到下来一天没debug出来,今天才发现原来结束条件需要尾节点
 * 也需要满足(n-1, n-2) ...
 * 思路就是模拟bfs,开一个vis[n][n][2]判断出现过
 * 头节点水平为0,竖直为1,然后就是无脑模拟了
 */

class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        if (grid[n - 1][n - 1] == 1) {
            return -1;
        }
        // 直接判断头就好了, 0是水平, 1是垂直
        boolean[][][] vis = new boolean[105][105][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 1, 0, 0});
        vis[0][1][0] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int headr = current[0], headc = current[1], tailr = current[2], tailc = current[3];
                if (headr == n - 1 && headc == n - 1 && tailr == n - 1 && tailc == n - 2) {
                    return level;
                }
                // 水平
                if (headr == tailr) {
                    // 向右
                    if (headc + 1 < n && grid[headr][headc + 1] == 0 && !vis[headr][headc + 1][0]) {
                        vis[headr][headc + 1][0] = true;
                        queue.offer(new int[] {headr, headc + 1, headr, headc});
                    }
                    if (headr + 1 < n) {
                        if (grid[headr + 1][headc] == 0 && grid[tailr + 1][tailc] == 0) {
                            // 向下掉头
                            if (!vis[headr + 1][tailc][1]) {
                                vis[headr + 1][tailc][1] = true;
                                queue.offer(new int[] {headr + 1, tailc, tailr, tailc});
                            }
                            // 向下
                            if (!vis[headr + 1][headc][0]) {
                                vis[headr + 1][headc][0] = true;
                                queue.offer(new int[] {headr + 1, headc, tailr + 1, tailc});
                            }
                        }
                    }
                } else {
                    // 向下
                    if (headr + 1 < n && grid[headr + 1][headc] == 0 && !vis[headr + 1][headc][1]) {
                        vis[headr + 1][headc][1] = true;
                        queue.offer(new int[] {headr + 1, headc, headr, headc});
                    }
                    if (headc + 1 < n) {
                        if (grid[headr][headc + 1] == 0 && grid[tailr][tailc + 1] == 0) {
                            // 向右掉头
                            if (!vis[tailr][headc + 1][0]) {
                                vis[tailr][headc + 1][0] = true;
                                queue.offer(new int[] {tailr, headc + 1, tailr, tailc});
                            }
                            // 向右
                            if (!vis[headr][headc + 1][1]) {
                                vis[headr][headc + 1][1] = true;
                                queue.offer(new int[] {headr, headc + 1, tailr, tailc + 1});
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}