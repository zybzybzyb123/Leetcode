/**
 * 先直接累加前缀和获取最小值,结果就是1 - Math.min(0, preFixSumMin)
 */

class Solution {
    public int minStartValue(int[] nums) {
        int ans = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            ans = Math.max(1 - sum, ans);
        }
        return ans;
    }
}