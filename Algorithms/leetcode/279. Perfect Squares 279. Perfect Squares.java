/**
 * 四平方定理 n=4^k*(8m+7)
 */

class Solution {
    private boolean isSqrt(int n) {
        int m = (int) Math.sqrt(n);
        return m * m == n;
    }

    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        if (isSqrt(n)) {
            return 1;
        }
        for (int i = 1; i * i <= n; i++) {
            if (isSqrt(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }
}