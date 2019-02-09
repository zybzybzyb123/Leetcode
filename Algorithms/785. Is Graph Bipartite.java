/**
 * 记得这道题的比赛我还打了，表示一直死活过不去
 * 看了测试数据我啥都懂了，没考虑非联通图的情况
 * 二分图判断就是染色法，dfs的经典应用
 */

class Solution {
    private boolean dfs(int from, int[][] graph, int[] color) {
        for (int i = 0; i < graph[from].length; i++) {
            int to = graph[from][i];
            if (color[to] == color[from]) {
                //System.out.format("from : %d, to : %d\n", from, to);
                return false;
            } else if (color[to] == 0) {
                color[to] = -color[from];
                if (!dfs(to, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        //System.out.format("len : %d\n", graph.length);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                if (!dfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}