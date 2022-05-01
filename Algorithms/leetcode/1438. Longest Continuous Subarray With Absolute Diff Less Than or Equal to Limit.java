/**
 * 维护两个单调队列
 */

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQue = new ArrayDeque<>();
        Deque<Integer> maxQue = new ArrayDeque<>();
        int left = -1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!minQue.isEmpty() && nums[minQue.peekLast()] >= nums[i]) {
                minQue.pollLast();
            }
            while (!maxQue.isEmpty() && nums[maxQue.peekLast()] <= nums[i]) {
                maxQue.pollLast();
            }
            minQue.offerLast(i);
            maxQue.offerLast(i);
            while (nums[maxQue.peekFirst()] - nums[minQue.peekFirst()] > limit) {
                if (maxQue.peekFirst() <= minQue.peekFirst()) {
                    left = maxQue.pollFirst();
                } else {
                    left = minQue.pollFirst();
                }
            }
            ans = Math.max(ans, i - left);
        }
        return ans;
    }
}