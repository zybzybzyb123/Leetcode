/**
 * 优先队列,其实可以直接暴力,一行一行的,每行最多处理前k个
 */

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length, sum = 0;
        // 前n个数的和放在最后一位上面
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[n] - b[n]);
        for (int i = 0; i < n; i++) {
            sum += mat[i][0];
        }
        int[] pos = new int[n + 1];
        pos[n] = sum;
        pq.offer(pos);
        int ans = 0;
        // Set<int[]>是有问题的,java的引用机制
        Set<String> vis = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int[] pre = pq.poll();
            ans = pre[n];
            for (int j = 0; j < n; j++) {
                if (pre[j] < mat[j].length - 1) {
                    int[] cur = Arrays.copyOf(pre, pre.length);
                    cur[n] += mat[j][pre[j] + 1] - mat[j][pre[j]];
                    cur[j]++;
                    String code = Arrays.toString(cur);
                    if (!vis.contains(code)) {
                        vis.add(code);
                        pq.offer(cur);
                    }
                }
            }
        }
        return ans;
    }
}