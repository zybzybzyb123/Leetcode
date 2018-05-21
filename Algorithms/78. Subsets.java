class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(null == nums || 0 == nums.length){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int m = 1 << nums.length;
        for(int i = 0; i < m; i++){
            int j = i, id = 0;
            while(j > 0){
                if((j & 1) != 0){
                    temp.add(nums[id]);
                }
                id++;
                j >>= 1;
            }
            ans.add(temp);
            temp = new ArrayList<>();
        }
        return ans;
    }
}