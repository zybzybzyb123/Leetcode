class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ans = 1;
        int Max = 0;
        //统计次数
        Map<Integer, Integer> cnt = new HashMap<>();
        //记录第一次出现的位置
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!cnt.containsKey(nums[i])){
                cnt.put(nums[i], 1);
                pos.put(nums[i], i);
            } else{
                cnt.put(nums[i], cnt.get(nums[i]) + 1);
                if(cnt.get(nums[i]) > Max){
                    Max = cnt.get(nums[i]);
                    //更新位置
                    ans = i - pos.get(nums[i]) + 1;
                } else if(cnt.get(nums[i]) == Max){
	                //优先选短的
                    ans = Math.min(ans, i - pos.get(nums[i]) + 1);
                }
            }
        }
        return ans;
    }
}