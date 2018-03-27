class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] top = new int[m];
        int[] left = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                left[i] = Math.max(left[i], grid[i][j]);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                top[i] = Math.max(top[i], grid[j][i]);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans += Math.min(left[i], top[j]) - grid[i][j];
            }
        }
        return ans;
    }
}