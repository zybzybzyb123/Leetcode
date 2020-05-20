/**
 * O(n) 解法注意保存当前最大和最小值,可能有负数
 */

class Solution {
    public int maxProduct(int[] nums) {
        int maxVal = nums[0], minVal = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = Math.max(minVal * nums[i], maxVal * nums[i]);
            int cutMin = Math.min(minVal * nums[i], maxVal * nums[i]);
            maxVal = Math.max(nums[i], curMax);
            minVal = Math.min(nums[i], cutMin);
            ans = Math.max(ans, maxVal);
        }
        return ans;
    }
}