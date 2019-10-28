/**
 * 无脑递归, 用个vis数组标记出现过的情况
 */

class Solution {
    private void circularPermutationHelper(int n, boolean[] vis, List<Integer> ans, int temp) {
        vis[temp] = true;
        ans.add(temp);
        for (int i = 0; i < n; i++) {
            //对应1 -> 0 和 0 -> 1
            if (((1 << i) & temp) > 0 && (!vis[temp ^ (1 << i)])) {
                circularPermutationHelper(n, vis, ans, temp ^ (1 << i));
            } else if (((1 << i) & temp) == 0 && (!vis[temp | (1 << i)])) {
                circularPermutationHelper(n, vis, ans, temp | (1 << i));
            }
        }
    }

    public List<Integer> circularPermutation(int n, int start) {
        boolean[] vis = new boolean[(1 << n) + 1];
        List<Integer> ans = new ArrayList<>();
        circularPermutationHelper(n, vis, ans, start);
        return ans;
    }
}