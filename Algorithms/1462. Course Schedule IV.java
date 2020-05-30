/**
 * DFS 复杂度O(NM) M为查询的长度
 */

class Solution {
    private boolean find(List[] lists, int from, int to, boolean[] vis) {
        vis[from] = true;
        for (int i = 0; i < lists[from].size(); i++) {
            int v = (int) lists[from].get(i);
            if (v == to || (!vis[v] && find(lists, v, to, vis))) {
                return true;
            }
        }
        return false;
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List[] lists = new List[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            lists[to].add(from);
        }
        List<Boolean> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int[] querie : queries) {
            int from = querie[0];
            int to = querie[1];
            ans.add(find(lists, to, from, vis));
            Arrays.fill(vis, false);
        }
        return ans;
    }
}