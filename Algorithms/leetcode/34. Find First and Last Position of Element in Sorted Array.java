/**
 * 二分我是左右单独处理的,左边用left,右边用right
 * 看到一个比较巧妙的解法,可以只写左边,如果存在右边就是比他大1的数的最左边的前一位
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = binarySearch(nums, target, true);
        int upper = binarySearch(nums, target, false);
        return new int[]{lower, upper};
    }

    private int binarySearch(int[] nums, int target, boolean lessOrMore) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (lessOrMore) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (lessOrMore) {
            if (left > nums.length - 1 || nums[left] != target) {
                return -1;
            }
            return left;
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}