/**
 * 回溯统计比较简单, 先写了个dp的方法要统计组合有点麻烦
 */

class Solution {
    private void dfs(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int cur, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            temp.add(candidates[i]);
            dfs(ans, temp, candidates, i, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(ans, list, candidates, 0, target);
        return ans;
    }
}