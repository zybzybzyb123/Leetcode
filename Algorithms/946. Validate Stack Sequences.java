/**
 * 第一眼还以为是uva第六章的例题，发现有细微区别
 * uva原题的push数组是固定的1-n，不过思路基本一样的
 * 如果栈顶元素等于pop就出栈，不然就入栈，最后判断
 * 栈是否为空
 */
class Solution {
    private static final int[] stack = new int[1005];
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;
        int top = -1;
        int n = pushed.length, i = 0, j = 0;
        while (j < n) {
            if(top != -1 && stack[top] == popped[j]) {
                top--;
                j++;
            } else {
                if (i == n) return false;
                stack[++top] = pushed[i++];
            }
        }
        return top == -1;
    }
}