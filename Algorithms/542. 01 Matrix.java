/**
 *  多源bfs
 */

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int base = 10001;
        int[][] ans = new int[n][m];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * base + j);
                }
            }
        }
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                int x = temp / base;
                int y = temp % base;
                for (int[] dir : dirs) {
                    int rx = x + dir[0];
                    int ry = y + dir[1];
                    if (rx >= 0 && rx < n && ry >= 0 && ry < m && matrix[rx][ry] == 1) {
                        ans[rx][ry] = level;
                        matrix[rx][ry] = 0;
                        queue.offer(rx * base + ry);
                    }
                }
            }
            level++;
        }
        return ans;
    }
}