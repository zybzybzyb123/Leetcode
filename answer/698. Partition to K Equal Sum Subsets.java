class Solution {
    private boolean dfs(int[] group, int sz, int[] nums, int t){
        if(sz < 0) return true;
        int cur = nums[sz--];
        for (int i = 0; i < group.length; i++) {
            if(group[i] + cur <= t){
                group[i] += cur;
                if(dfs(group, sz, nums, t)) return true;
                group[i] -= cur;
            }
            if(group[i] == 0) break;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        if(sum % k != 0 || nums[nums.length - 1] > sum / k){
            return false;
        }
        int t = sum / k;
        int sz = nums.length - 1;
        while(sz >=0 && nums[sz] == t){
            sz--;
            k--;
        }
        return dfs(new int[k], sz, nums, t);
    }
}