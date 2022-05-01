/**
 * 统计奇数的位置
 */

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] pos = new int[nums.length + 2];
        int id = 0;
        pos[id++] = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                pos[id++] = i;
            }
        }
        // 前面加0,末尾加nums.length
        pos[id++] = nums.length;
        int ans = 0;
        // 前一个奇数之后和后一个奇数之前
        for (int i = 1; i + k < id; i++) {
            ans += (pos[i] - pos[i - 1]) * (pos[i + k] - pos[i + k - 1]);
        }
        return ans;
    }
}