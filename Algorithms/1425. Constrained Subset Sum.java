/**
 * 打卡,双端队列优化dp
 */

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<int[]> queue = new ArrayDeque();
        int[] dp = new int[nums.length];
        int ans = nums[0];
        queue.offer(new int[]{0, nums[0]});
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i], queue.peekFirst()[1] + nums[i]);
            while (!queue.isEmpty() && queue.peekLast()[1] <= dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(new int[]{i, dp[i]});
            if (queue.peek()[0] <= i - k) {
                queue.pollFirst();
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}