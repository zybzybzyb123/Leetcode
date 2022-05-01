//变种二分法
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length / 2, mid = 0;
        while(left < right){
            mid = left + (right - left) / 2;
            if(nums[mid * 2] != nums[mid * 2 + 1]){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        return nums[left * 2];
    }
}