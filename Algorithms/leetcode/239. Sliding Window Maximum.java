/**
 * 队列O(N)解法
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) {
                deque.addLast(i);
            } else {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
        }
        for (int i = 0; i + k - 1 < nums.length; i++) {
            if (i == 0) {
                ans[0] = deque.peekFirst();
                continue;
            }
            int val = nums[i + k - 1];
            while (!deque.isEmpty() && nums[deque.peekLast()] <= val) {
                deque.pollLast();
            }
            deque.offerLast(i + k - 1);
            if (deque.peekFirst() < i) {
                deque.pollFirst();
            }
            ans[i] = deque.peekFirst();
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[ans[i]];
        }
        return ans;
    }
}