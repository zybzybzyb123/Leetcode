/**
 * 第一次见到这个题还是在饿了么的校园招聘
 * 会上面，当时没有写出来，今天又看到这道题花了十几分钟就
 * AC了，其实本质就是一个带条件的递归
 */
class Solution {
    /**
     * @param ans 结果数组
     * @param array
     * @param cur 当前位置
     * @param leftBracketCount 左括号计数
     * @param rightBracketCount 右括号计数
     * @param n 括号对数
     */
    private void dfs(List<String> ans, char[] array, int cur, int leftBracketCount, int rightBracketCount, int n) {
        if (cur == 2 * n) {
            ans.add(new String(array));
            return;
        }
        if (leftBracketCount < n) {
            array[cur] = '(';
            dfs(ans, array, cur + 1, leftBracketCount + 1, rightBracketCount, n);
        }
        if (leftBracketCount > rightBracketCount) {
            array[cur] = ')';
            dfs(ans, array, cur + 1, leftBracketCount, rightBracketCount + 1, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] array = new char[2 * n];
        dfs(ans, array, 0, 0, 0, n);
        return ans;
    }
}
