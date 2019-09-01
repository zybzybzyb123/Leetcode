/**
 * 测试样例有歧义,其实就是一个最最简单的滑动窗口
 */
class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int ans = 0, cnt = 0, len = 0;
        for (int i = 0; i < calories.length; i++) {
            if (len < k) {
                len++;
                cnt += calories[i];
            } else {
                cnt += calories[i] - calories[i - k];
            }
            if (len == k) {
                if (cnt > upper) {
                    ans++;
                } else if (cnt < lower) {
                    ans--;
                }
            }
        }
        return ans;
    }
}