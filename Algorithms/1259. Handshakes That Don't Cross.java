/**
 * 卡特兰数,注意取余相乘是会变大就好了
 * 我用大数解的,可以直接用
 * f(n + 1) = f(n) * (4 * n - 2) / (n + 1) 递推公式
 */

import java.math.BigInteger;

class Solution {
    public int numberOfWays(int num_people) {
        BigInteger ans = BigInteger.ONE;
        int mod = 1_000_000_000 + 7;
        for (int i = 1; i <= num_people / 2; i++) {
            ans = ans.multiply(BigInteger.valueOf(4 * i - 2)).divide(BigInteger.valueOf(i + 1));
        }
        return ans.mod(BigInteger.valueOf(mod)).intValue();
    }
}