/**
 * 这个题做比较好做，就是写的比较简单有点麻烦其实顺时针是有规律的,
 * 每一个方向移动步数是1 1 2 2 3 3 4 4。。。
 * 方向分别是右下左上，申明一个方向数组就可以把代码写的很短
 * 其实还可以对越界的进行优化，让代码稍微快一点
 */
class Solution {
    private boolean inside(int i, int j, int R, int C) {
        if (i < R && i >= 0 && j < C && j >= 0) {
            return true;
        }
        return false;
    }
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int t = 0, n = R * C;
        int[][] res = new int[n][2];
        int[][] dir = new int[][]{{0,1},{1,0}, {0, -1}, {-1, 0}};
        int step = 0;
        res[t][0] = r0;
        res[t++][1] = c0;
        while (t < n) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) step++;
                for (int j = 0; j < step; j++) {
                    r0 += dir[i][0];
                    c0 += dir[i][1];
                    if (inside(r0, c0, R, C)) {
                        res[t][0] = r0;
                        res[t++][1] = c0;
                    }
                }
            }
        }
        return res;
    }
}