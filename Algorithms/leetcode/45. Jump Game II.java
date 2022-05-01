/**
 * 记录最右边位置,每次更新区间最大值为下一个最右边端点位置
 */

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int end = 0, maxPos = 0, step = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(i + nums[i], maxPos);
            if (maxPos >= nums.length - 1) {
                return step + 1;
            }
            if (i == end) {
                step++;
                end = maxPos;
            }
        }
        return step;
    }
}