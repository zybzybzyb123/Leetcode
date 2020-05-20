/**
 * 拓扑排序
 */

class Solution {
    private int[] res;
    private int n;
    private boolean topoSort(List[] lists, int cur, int[] flag) {
        // -1表示正在访问
        flag[cur] = -1;
        for (int i = 0; i < lists[cur].size(); i++) {
            int to = (int) lists[cur].get(i);
            // 其他节点遍历过的节点不要重复遍历
            if (flag[to] == -1
                    || (flag[to] == 0 && !topoSort(lists, to, flag))) {
                return false;
            }
        }
        // 1表示访问过, 如需要打印topo排序, 从后往前存top[--n] = cur;
        res[--n] = cur;
        flag[cur] = 1;
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] lists = new List[numCourses];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            lists[to].add(from);
        }

        int[] flag = new int[numCourses];
        res = new int[numCourses];
        n = numCourses;
        for (int i = 0; i < numCourses; i++) {
            if (flag[i] == 0 && !topoSort(lists, i, flag)) {
                return new int[0];
            }
        }
        return res;
    }
}