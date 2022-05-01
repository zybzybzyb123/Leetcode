class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        for(int i = 0; i < nums.length; i++){
            int pos = nums[i] > 0 ? nums[i] - 1 : -nums[i] - 1; 
            if(nums[pos] < 0){
                ans.add(nums[i] > 0 ? nums[i] : -nums[i]);
            }
            nums[pos] = -nums[pos]; 
        }
        return ans;
    }
}
