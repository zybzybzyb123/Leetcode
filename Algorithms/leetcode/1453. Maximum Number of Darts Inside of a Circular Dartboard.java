/**
 * O(n ^ 3) 根据两个点确认圆心, 最后判断在不在
 * 计算圆心是基于相似三角形
 */

class Solution {
    private double dis(int[] a, int[] b) {
        return Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
    }

    private double[] getCenterCircle(int[] pointA, int[] pointB, int r) {
        double x1 = (pointA[0] + pointB[0]) / 2.0;
        double y1 = (pointA[1] + pointB[1]) / 2.0;
        double p2 = (x1 - pointA[0]) * (x1 - pointA[0]) + (y1 - pointA[1]) * (y1 - pointA[1]);
        double p = Math.sqrt(p2);
        double h = Math.sqrt(r * r - p2);
        // 这里有顺序问题, 如果只返回一个点, 那外层循环要包含 j小于i的情况
        double rx = (y1 - pointA[1]) *  h / p;
        double ry = ((x1 - pointA[0])) * h / p;
        return new double[] {x1 + rx, y1 - ry, x1 - rx, y1 + ry};
    }

    public int numPoints(int[][] points, int r) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dis(points[i], points[j]) > 2 * r) {
                    continue;
                }
                // 计算上下两个点
                double[] centerCircle = getCenterCircle(points[i], points[j], r);
                int curCnt1 = 0;
                int curCnt2 = 0;
                for (int k = 0; k < n; k++) {
                    if ((centerCircle[0] - points[k][0]) * (centerCircle[0] - points[k][0])
                            + (centerCircle[1] - points[k][1]) * (centerCircle[1] - points[k][1]) <= r * r) {
                        curCnt1++;
                    }

                    if ((centerCircle[2] - points[k][0]) * (centerCircle[2] - points[k][0])
                            + (centerCircle[3] - points[k][1]) * (centerCircle[3] - points[k][1]) <= r * r) {
                        curCnt2++;
                    }
                }
                ans = Math.max(ans, Math.max(curCnt1, curCnt2));
            }
        }
        return ans;
    }
}