/**
 * 栈模拟就过了,保存字母和次数信息
 */

class Solution {
    private static final int BASE = 1_000_000;
    public String removeDuplicates(String s, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            int pos = ch - 'a';
            if (stack.isEmpty() || stack.peek() / BASE != pos) {
                stack.push(pos * BASE + 1);
            } else {
                int top = stack.pop();
                if (top % BASE < k - 1) {
                    stack.push(top + 1);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            char ch = (char) (top / BASE + 'a');
            for (int i = top % BASE; i > 0; i--) {
                ans.append(ch);
            }
        }
        return ans.reverse().toString();
    }
}