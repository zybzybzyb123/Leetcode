/**
 * 经典的单调栈，具体看代码了，不细说了
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] stack = new int[list.size() + 10];
        int[] ans = new int[list.size()];
        int top = -1;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            while (top >= 0 && list.get(stack[top]) < val) {
                ans[stack[top--]] = val;
            }
            stack[++top] = i;
        }
        return ans;
    }
}