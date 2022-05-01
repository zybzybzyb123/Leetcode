/**
 * 这个题可以打表,不过n * (sqrt(n))也够用了
 */

class Solution {
    private int getRes(int num) {
        int m = (int) Math.sqrt(num);
        if (num == m * m) {
            return 0;
        }
        int cnt = 0;
        int ans = 1 + num;
        for (int i = 2; i <= m; i++) {
            if (num % i == 0) {
                if (cnt > 0) {
                    return 0;
                }
                ans += i + num / i;
                cnt++;
            }
        }
        if (cnt == 0) {
            return 0;
        }
        return ans;
    }
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += getRes(num);
        }
        return ans;
    }
}