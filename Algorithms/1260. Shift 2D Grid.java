/**
 * 坐标映射找到左移k的位置
 */
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length, len = n * m;
        k = (len - k % len) % len;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int cur = (i * m + j + k) % len;
                temp.add(grid[cur / m][cur % m]);
            }
            ans.add(temp);
        }
        return ans;
    }
}