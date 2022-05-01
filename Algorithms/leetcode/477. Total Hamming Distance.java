class Solution {
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int cnt = 0;
            for(int j = 0; j < nums.length; j++){
                if(((nums[j] >>> i) & 1) == 1){
                    cnt++;
                }
            }
            ans += cnt * (nums.length - cnt);
        }
        return ans;
    }
}