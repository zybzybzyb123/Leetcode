/**
 * topo排序判断圈 -1 0 1三个状态
 */

class Edge {
    List<Integer> toLists = new ArrayList<>();
}

class Solution {

    private boolean isCircle(Edge[] edges, int cur, int[] flag) {
        // -1表示正在访问
        flag[cur] = -1;
        for (int to : edges[cur].toLists) {
            if (flag[to] == -1 || isCircle(edges, to, flag)) {
                return true;
            }
        }
        // 1表示访问过, 如需要打印topo排序, 从后往前存top[--n] = cur;
        flag[cur] = 1;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Edge[] edges = new Edge[numCourses];
        // 注意Arrays.fill初始化的坑
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            edges[to].toLists.add(from);
        }
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (flag[i] == 0) {
                if (isCircle(edges, i, flag)) {
                    return false;
                }
            }
        }
        return true;
    }
}