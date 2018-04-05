class Solution {
    private void dfs(int cur, int tot, int k, int n, List<Integer> path, List<List<Integer>> ans){
        if(cur == k && tot == n){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(cur > k || tot > n){
            return;
        }
        int begin = path.size() == 0 ? 0 : path.get(path.size() - 1);
        for(int i = begin + 1; i <= 9; i++){
            if(tot + i <= n){
//                vis[i] = true;
                path.add(i);
                dfs(cur + 1, tot + i, k, n, path, ans);
//                vis[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if(k == 0 || n == 0 || k > 9 || n > 45) return ans;
        List<Integer> path = new ArrayList<>();
        dfs(0, 0, k, n, path, ans);
        return ans;
    }
}