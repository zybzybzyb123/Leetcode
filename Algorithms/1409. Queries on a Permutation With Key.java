/**
 * O(N^2)模拟
 * 可以用树状数组优化到O(N^LogN)
 */

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = i + 1;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (queries[i] == num[j]) {
                    ans[i] = j;
                    break;
                }
            }
            int temp = num[ans[i]];
            for (int j = ans[i] - 1; j >= 0 ; j--) {
                num[j + 1] = num[j];
            }
            num[0] = temp;
        }
        return ans;
    }
}