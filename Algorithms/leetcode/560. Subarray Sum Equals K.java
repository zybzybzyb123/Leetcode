/**
 * 前缀和加哈系表,一边遍历一边计算
 * 简单优化省一个前缀数组
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, pre = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            ans += cntMap.getOrDefault(pre - k, 0);
            cntMap.put(pre, cntMap.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}