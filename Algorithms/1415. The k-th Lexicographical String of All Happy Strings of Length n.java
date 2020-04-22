/**
 * 为了方便用了全局变量,无脑dfs,其实是可以直接算出来的
 * 因为每个n的字符串最多有3 * 2 ^ (n - 1)种可能,
 * 所以是可以根据k从头一位一位的计算出来的
 */

class Solution {
    // 无脑dfs法
    private String ans = "";
    private int curPos = 0;
    private char[] chArray = {'a', 'b', 'c'};
    private void dfs(char[] array, int cur) {
        if (cur == array.length) {
            if (--curPos == 0) {
                ans = new String(array);
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (cur > 0 && chArray[i] == array[cur - 1]) {
                continue;
            }
            array[cur] = chArray[i];
            dfs(array, cur + 1);
        }
    }
    public String getHappyString(int n, int k) {
        char[] array = new char[n];
        curPos = k;
        dfs(array, 0);
        return ans;
    }
}