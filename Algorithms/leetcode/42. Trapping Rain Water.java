/**
 * 单调栈
 * 双指针解法
 */

class Solution {
    // 单调栈
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int pre = stack.peek();
                // 左右的小值 * 间隔
                ans += (Math.min(height[pre], height[i]) - height[cur]) * (i - pre - 1);
            }
            stack.push(i);
        }
        return ans;
    }

    // 双指针
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(height[left], leftMax);
                ans += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}