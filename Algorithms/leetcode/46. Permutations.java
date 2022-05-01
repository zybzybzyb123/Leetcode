/**
 * 简单回溯
 */

class Solution {
    private void dfs(int[] nums, int[] res, int cur, boolean[] vis, List<List<Integer>> ans) {
        if (cur == res.length) {
            List<Integer> temp = new ArrayList<>();
            for (int val : res) {
                temp.add(val);
            }
            ans.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                res[cur] = nums[i];
                dfs(nums, res, cur + 1, vis, ans);
                vis[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, new int[nums.length], 0, new boolean[nums.length], ans);
        return ans;
    }
}