/**
 * 刷题用lambda表达式都是巨慢，我也很无奈
 */
class Solution {
    int[] stack = new int[30];
    public int scoreOfParentheses(String S) {
        int top = 0, ans = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            switch (ch) {
                case '(': stack[top++] = -1; break;
                case ')': {
                    int tot = 0;
                    while (stack[top - 1] != -1) {
                        tot += stack[--top];
                    }
                    //System.out.format("tot = %d\n", tot);
                    stack[top - 1] = tot == 0 ? 1 : (tot << 1);
                } break;
                default: break;
            }
        }
        return return Arrays.stream(stack).limit(top).sum();
        /**
        for (int i = 0; i < top; i++) {
            ans += stack[i];
        }
        return ans
        */
    }
}