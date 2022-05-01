class Solution {

    //不用额外空间解法
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (j > i + 1 && (nums[j] == nums[j - 1])) {
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] <= 0) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}