/**
 * 先实现了一个dfs的版本,并查集
 */

class Solution {
    private void dfs(int u, List<Integer>[] edges, boolean[] vis, List<Integer> list) {
        vis[u] = true;
        list.add(u);
        for (int i = 0; i < edges[u].size(); i++) {
            int v = edges[u].get(i);
            if (!vis[v]) {
                dfs(v, edges, vis, list);
            }
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }
        char[] ans = s.toCharArray();
        List<Integer>[] edges = new ArrayList[s.length()];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        //我先假设pairs不重复
        for (List<Integer> pair : pairs) {
            int from = pair.get(0), to = pair.get(1);
            edges[from].add(to);
            edges[to].add(from);
        }
        boolean[] vis = new boolean[s.length()];
        List<Integer> temp = new ArrayList<>();
        char[] array = new char[s.length()];
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].size() > 0 && !vis[i]) {
                dfs(i, edges, vis, temp);
            }
            Collections.sort(temp);
            int id = 0;
            for (int pos : temp) {
                array[id++] = ans[pos];
            }
            Arrays.sort(array, 0, id);
            for (int j = temp.size() - 1; j >= 0 ; j--) {
                ans[temp.get(j)] = array[--id];
            }
            temp = new ArrayList<>();
        }
        return new String(ans);
    }
}