/**
 * 写了个用栈的最简单的方法
 * 不过看了别人的思路，可以不借用栈，用两个变量就行了
 */

class Solution {
    public boolean isValid(String S) {
        LinkedList<Integer> stash = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            int val = ch - 'a';
            if (val == 0) {
                stash.push(val);
            } else if (val == 1) {
                if (stash.size() < 1 || stash.peek() != 0) {
                    return false;
                }
                stash.push(val);
            } else {
                if (stash.size() < 2) {
                    return false;
                }
                int x = stash.pop(), y = stash.pop();
                if (x != 1 || y != 0) {
                    return false;
                }
            }
        }
        return stash.isEmpty();
    }
}