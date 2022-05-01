/**
 * 这个题开始按照直线考虑的想的太过于简单了
 * 学习了下向量法判断是否在内部
 */

class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        double x0 = (x2 + x1) / 2;
        double y0 = (y2 + y1) / 2;
        double[] p = {Math.abs(x_center - x0), Math.abs(y_center - y0)};
        double[] q = {x2 - x0, y2 - y0};
        double[] u = {Math.max(p[0] - q[0], 0.0), Math.max(p[1] - q[1], 0.0)};
        return u[0] * u[0] + u[1] * u[1] <= radius * radius;
    }
}