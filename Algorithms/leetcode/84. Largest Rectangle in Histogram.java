/**
 * 单调栈
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                ans = Math.max(heights[cur] * (i - left - 1), ans);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            ans = Math.max(heights[cur] * (heights.length - left - 1), ans);
        }
        return ans;
    }
}