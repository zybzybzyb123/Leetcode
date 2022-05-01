/**
 * 维护一个最右的坐标就好了
 */

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int rightPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (rightPos < i) {
                return false;
            }
            rightPos = Math.max(rightPos, i + nums[i]);
        }
        return true;
    }
}