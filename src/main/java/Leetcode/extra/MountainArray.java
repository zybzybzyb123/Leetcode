package Leetcode.extra;

/**
 * @author zero
 * @created 2020/04/29
 */
public class MountainArray {

    private int[] nums;
    public MountainArray(int[] nums) {
        this.nums = nums;
    }
    public int get(int index) {
        if (index < 0 || index >= nums.length) {
            return -1;
        }
        return nums[index];
    }
    public int length() {
        return nums.length;
    }
}
