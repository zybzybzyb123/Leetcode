/**
 * 矩阵快速幂，测试数据挺无语的，注意处理Integer.MIN_VALUE
 */

class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        double ans = 1.0, temp = x;
        if(n < 0){
            if(n == Integer.MIN_VALUE){
                ans = 1 / x;
                n = Integer.MAX_VALUE;
            } else{
                n = -n;
            }
            x = 1 / x;
            temp = x;
        }
        while(n > 0){
            if((n & 1) != 0){
                ans *= temp;
            }
            temp *= temp;
            n >>= 1;
        }
        return ans;
    }
}