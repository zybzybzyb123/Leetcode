class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length == 1) return 0;
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ans = 0;
        for(int num : nums){
            ans += Math.abs(num - mid);
        }
        return ans;
    }
}
