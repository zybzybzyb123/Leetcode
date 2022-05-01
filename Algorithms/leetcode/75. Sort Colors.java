/**
 * 荷兰国旗问题,参考了下讨论区(感觉花点时间自己也能想出来)
 */

class Solution {
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        //左右指针加上当前指针,快排partiton完全可以用这个
        int i = 0, j = nums.length - 1, cur = 0;
        while (cur <= j) {
            if (nums[cur] == 0) {
                swap(nums, i++, cur++);
            } else if (nums[cur] == 2) {
                swap(nums, cur, j--);
            } else {
                cur++;
            }
        }
    }
}