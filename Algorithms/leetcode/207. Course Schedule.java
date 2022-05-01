/**
 * dfs, 注意不要重复遍历
 */

class Solution {

    private boolean topoSort(List[] lists, int cur, int[] flag) {
        // -1表示正在访问
        flag[cur] = -1;
        for (int i = 0; i < lists[cur].size(); i++) {
            int to = (int) lists[cur].get(i);
            if (flag[to] == -1
                    || (flag[to] == 0 && !topoSort(lists, to, flag))) {
                return false;
            }
        }
        // 1表示访问过
        flag[cur] = 1;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        for (int i = 0; i < numCourses; i++) {
            if (flag[i] == 0 && !topoSort(lists, i, flag)) {
                return false;
            }
        }
        return true;
    }
}