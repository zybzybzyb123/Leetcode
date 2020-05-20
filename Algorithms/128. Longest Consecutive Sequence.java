/**
 * 主要优化是只计算单边 保证从小到大的找
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(nums[i] - 1)) {
                int curCnt = 1;
                int curNum = nums[i];
                while (numSet.contains(curNum + 1)) {
                    curNum++;
                    curCnt++;
                }
                ans = Math.max(ans, curCnt);
            }
        }
        return ans;
    }
}