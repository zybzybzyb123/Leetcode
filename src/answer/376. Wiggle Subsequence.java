class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        boolean flag = false;
        int ans = 1, begin = nums.length + 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]){
                begin = i;
                ans++;
                flag = nums[i] > nums[i - 1] ? true : false;
                break;
            }
        }
        for(int i = begin + 1; i < nums.length; i++){
            if((flag && nums[i] < nums[i - 1]) || (!flag && nums[i] > nums[i - 1])){
                ans++;
                flag = !flag;
            }
        }
        return ans;
    }
}