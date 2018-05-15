/**
 * 矩阵旋转，之前看的解法是模拟旋转，热后每次
 * 缩小矩阵大小，这次这个翻转两次的解法也挺巧妙
 */
class Solution {
    public void rotate(int[][] matrix) {
        if(null == matrix || matrix.length == 0) return;
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}