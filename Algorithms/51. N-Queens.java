/**
 * 经典n皇后问题
 */

class Solution {
    private static char[] EMPTY;
    private void nQueue(int n, int cur, boolean[] vis, int[] col, List<List<String>> ans, List<String> temp) {
        if (cur == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                boolean ok = true;
                for (int j = 0; j < cur; j++) {
                    //当前列或者对角线存在返回
                    if (cur - j == i - col[j] || cur - j == col[j] - i) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    continue;
                }
                vis[i] = true;
                col[cur] = i;
                EMPTY[i] = 'Q';
                temp.add(new String(EMPTY, 0, n));
                EMPTY[i] = '.';
                nQueue(n, cur + 1, vis, col, ans, temp);
                temp.remove(temp.size() - 1);
                vis[i] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return Collections.EMPTY_LIST;
        }
        EMPTY = new char[n];
        Arrays.fill(EMPTY, '.');
        List<List<String>> ans = new ArrayList<>();
        int[] col = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(col, -1);
        nQueue(n, 0, vis, col, ans, new ArrayList<>());
        return ans;
    }
}