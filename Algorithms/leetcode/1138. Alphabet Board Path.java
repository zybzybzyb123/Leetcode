/**
 * 这个题主要是处理z，解决这个浪费了点时间
 * 如果从z开始可以先往上一步
 * 如果到达的是z可以假设到达的是u，最后再单独执行向下
 */

class Solution {
    private void helper(char src, char des, StringBuilder ans) {
        if (src == des) {
            return;
        }
        int x = (src - 'a') % 5, y = (src - 'a') / 5;
        int x1 = (des - 'a') % 5, y1 = (des - 'a') / 5;
        char opx = x1 > x ? 'R': 'L';
        char opy = y1 > y ? 'D': 'U';
        for (int i = 0; i < Math.abs(y - y1); i++) {
            ans.append(opy);
        }
        for (int i = 0; i < Math.abs(x - x1); i++) {
            ans.append(opx);
        }
    }
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        char cur = 'a';
        for (char ch : target.toCharArray()) {
            if (ch != cur) {
                if (cur == 'z') {
                    ans.append('U');
                    cur = 'u';
                }
                if (ch == 'z') {
                    helper(cur, 'u', ans);
                    ans.append('D');
                } else {
                    helper(cur, ch, ans);
                }
                cur = ch;
            }
            ans.append('!');
        }
        return ans.toString();
    }
}