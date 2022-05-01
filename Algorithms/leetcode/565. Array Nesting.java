/**
 * 自己本来用一个vis数组判断重复的
 * 参考了讨论区发现可以用nums数组本身
 * 来实现，比之前快一点
 */
class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 1;
        for(int i = 0; i < nums.length; i++) {
            int cnt = 0, j = i;
            while (nums[j] >= 0) {
                cnt++;
                int old = j;
                j = nums[j];
                nums[old] = -1;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}