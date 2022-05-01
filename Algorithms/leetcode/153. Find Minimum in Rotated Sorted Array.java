/**
 * 二分法,注意右边界
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] <  nums[right]) {
                break;
            }
            int mid = left + ((right - left) >> 1);
            if (nums[mid]  > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}