/**
 * 用栈做的,用递归也可以做
 */
class Solution {
    public String reverseParentheses(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    temp.append(stack.pop());
                }
                stack.pop();
                for (char ch1 : temp.toString().toCharArray()) {
                    stack.push(ch1);
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}

//递归解法
class Solution {
    private void swap(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
    }
    private void helper(char[] array, int begin) {
        for (int i = begin; i < array.length; i++) {
            if (array[i] == '(') {
                helper(array, i + 1);
            } else if (array[i] == ')') {
                swap(array, begin, i - 1);
                //替换为不会出现的任何字符都行
                array[begin - 1] = array[i] = 0;
                return;
            }
        }
    }

    public String reverseParentheses(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] array = s.toCharArray();
        helper(array, 0);
        StringBuilder ans = new StringBuilder();
        for (char ch : array) {
            if (ch > 0) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}