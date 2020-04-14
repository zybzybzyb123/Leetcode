/**
 * 前缀和加哈系表,一边遍历一边计算
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        int ans = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);
        for (int i = 0; i < sum.length; i++) {
            if (cntMap.containsKey(sum[i]- k)) {
                ans += cntMap.get(sum[i]- k);
            }
            int cnt = cntMap.getOrDefault(sum[i], 0) + 1;
            cntMap.put(sum[i], cnt);
        }
        return ans;
    }
}