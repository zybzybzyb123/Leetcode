/**
 * 排序看两边的第一个顺序不符合的就是需要调整的子序列
 */

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        boolean needSort = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                needSort = true;
                break;
            }
        }
        if (!needSort) {
            return 0;
        }
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int begin = 0;
        int end = temp.length - 1;
        while (begin < temp.length && temp[begin] == nums[begin]) {
            begin++;
        }
        while (end >= 0 && temp[end] == nums[end]) {
            end--;
        }
        return end - begin + 1;
    }
}