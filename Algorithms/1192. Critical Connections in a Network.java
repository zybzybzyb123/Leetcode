/**
 * 图论找桥,和割顶有一点点区别(是否包含当前节点)
 * dfs的变形,参考了训练指南的代码还是比较好理解的
 * 边的关系可以用数组模拟链表维护,我之前直接map存
 * 还超时...
 */

class Solution {
    private int cnt = 0;
    private int[] pre;
    private List<List<Integer>> ans;
    private int dfs(int u, int fa, List<Integer>[] edgeList) {
        int lowU = pre[u] = ++cnt;
        for (int v : edgeList[u]) {
            //一定要过滤直接的父节点,无向图
            if (v == fa) {
                continue;
            }
            //没有访问过,要递归
            if (pre[v] == 0) {
                int lowV = dfs(v, u, edgeList);
                //lowU保存所有儿子节点能访问到的最小值
                lowU = Math.min(lowU, lowV);
                if (lowV > pre[u]) {
                    ans.add(Arrays.asList(u, v));
                }
            } else if (pre[v] < pre[u]) {
                lowU = Math.min(pre[v], lowU);
            }
        }
        return lowU;
    }

    private void init (int n) {
        cnt = 0;
        pre =  new int[n + 1];
        ans = new ArrayList<>();
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        init(n);
        List<Integer>[] edgeList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            int key = Math.min(connection.get(0), connection.get(1)), value = Math.max(connection.get(0), connection.get(1));
            edgeList[key].add(value);
            edgeList[value].add(key);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, -1, edgeList);
        }
        return ans;
    }
}