/**
 * 从大到小排序和大于总和一般就是结果
 */
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum(), cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            cnt += nums[i];
            ans.add(nums[i]);
            if (cnt > sum - cnt) {
                break;
            }
        }
        return ans;
    }
}