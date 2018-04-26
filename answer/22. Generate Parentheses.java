/**
 * 第一次见到这个题还是在饿了么的校园招聘
 * 会上面，当时没有写出来，今天又看到这道题花了十几分钟就
 * AC了，其实本质就是一个带条件的递归
 */
class Solution {
    //temp保存括号序列的字符数组, ans是答案数组, cur表示当前容量, n是括号数，
    // leftCnt是当前左括号的总数, left是匹配完右括号剩余的左括号数
    private void dfs(char[] temp, List<String> ans, int cur, int n, int leftCnt, int left){
        if(cur == 2 * n){
            ans.add(new String(temp));
            return;
        }
        if(left > 0){
            temp[cur] = ')';
            dfs(temp, ans, cur + 1, n, leftCnt, left - 1);
        }
        if(leftCnt < n){
            temp[cur] = '(';
            dfs(temp, ans, cur + 1, n, leftCnt + 1, left + 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n <= 0) return ans;
        char[] temp = new char[2 * n];
        temp[0] = '(';
        dfs(temp, ans, 1, n, 1, 1);
        return ans;
    }
}
