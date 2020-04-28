/**
 * 异或找到两个单独的数,再针对1的位根据0和1分成两类
 */

class Solution {
    public int[] singleNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        int val = 1;
        while ((ans & val) == 0) {
            val <<= 1;
        }
        int ans1 = 0;
        for (int num : nums) {
            if ((num & val) == 0) {
                ans1 ^= num;
            }
        }
        return new int[]{ans1, ans ^ ans1};
    }
}