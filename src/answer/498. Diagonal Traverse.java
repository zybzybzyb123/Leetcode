class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return new int[0];
        int m = matrix[0].length;
        if(m == 0) return new int[0];
        int[] res = new int[n * m];
        boolean dir = false;
        int i = 0, j = 0, t = 0;
        res[t++] = matrix[i][j];
        while(t < m * n){
            dir = !dir;
            if(dir){
                if(j < m - 1){
                    j++;
                } else{
                    i++;
                }
                res[t++] = matrix[i][j];
                while(i < n - 1 && j > 0){
                    i++;
                    j--;
                    res[t++] = matrix[i][j];
                }
            } else{
                if(i < n - 1){
                    i++;
                } else{
                    j++;
                }
                res[t++] = matrix[i][j];
                while(i > 0 && j < m - 1){
                    i--;
                    j++;
                    res[t++] = matrix[i][j];
                }
            }
        }
        return res;   
    }
}