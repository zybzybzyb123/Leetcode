/**
 * 排序再合并就好了
 * 优化下代码
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[][] res = new int[intervals.length][2];
        int id = 0;
        res[id++] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > res[id - 1][1]) {
                res[id++] = intervals[i];
            } else {
                if (intervals[i][1] > res[id - 1][1]) {
                    res[id - 1][1] = intervals[i][1];
                }
            }
        }
        return Arrays.copyOf(res, id);
    }
}