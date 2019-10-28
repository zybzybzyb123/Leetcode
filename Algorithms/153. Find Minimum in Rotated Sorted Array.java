/**
 * 二分,不过坑有点多
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            //特殊处理就两个的情况
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[left] && nums[mid] > nums[right - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}