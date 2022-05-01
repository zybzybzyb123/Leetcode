/**
 * 用栈比较常规.就是细节不好写的比较简略
 * 用栈存字符是最简单的实现
 */

class Solution {
    // 栈
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        LinkedList<Integer> cntStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                cntStack.push(num);
                num = 0;
                stack.push(res.toString());
                res = new StringBuilder();
            } else if (ch == ']') {
                int cnt = cntStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < cnt; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack.pop() + temp);
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    // 递归法, 全局变量记录当前cursor
    private int cur = 0;
    private String dfs(char[] array) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        while (cur < array.length) {
            char ch = array[cur];
            if (ch == '[') {
                cur++;
                String temp = dfs(array);
                while (num > 0) {
                    res.append(temp);
                    num--;
                }
            } else if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            } else if (ch == ']') {
                return res.toString();
            } else {
                res.append(ch);
            }
            cur++;
        }
        return res.toString();
    }
    public String decodeString(String s) {
        return dfs(s.toCharArray());
    }
}