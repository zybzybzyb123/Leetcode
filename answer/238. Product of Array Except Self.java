class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1, cnt = 0;
        for(int num : nums){
            if(num == 0){
                cnt++;
            } else{
                product *= num;
            }
        }
        if(cnt < 2){
            for(int i = 0; i < nums.length; i++){
                if(cnt == 1 && nums[i] == 0){
                    ans[i] = product;
                } else if(cnt == 0){
                    ans[i] = product / nums[i];
                }
            }
        }
        return ans;
    }
}