/**
 * 记录前一个1的位置
 */

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pos != -1 && i - pos - 1 < k) {
                    return false;
                }
                pos = i;
            }
        }
        return true;
    }
}