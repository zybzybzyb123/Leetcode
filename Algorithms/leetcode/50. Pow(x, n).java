/**
 * 矩阵快速幂, 注意最大负数这个坑
 */

class Solution {
    public double myPow(double x, int n) {
        // 注意最大负数,直接加负号会溢出
        long m = n > 0 ? n : 0L - n;
        double ans = 1.0;
        while (m > 0) {
            if ((m & 1) == 1) {
                ans *= x;
            }
            x *= x;
            m /= 2;
        }
        return n > 0 ? ans : 1 / ans;
    }
}