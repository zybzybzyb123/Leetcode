/**
 * 题目就是把两个列表的交集合并输出
 * 主要处理有交集的情况，假设分别为a和b两个区间，
 * 简单分析就知道交集为【max(a.start, b.start)， min(a.end, b.end)】
 * 关键就是之后的指针移动，end较小的区间可能在下一个区间仍然和当前
 * end较大的区间存在交集
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A.length == 0 || B.length == 0) {
            return new Interval[0];
        }
        List<Interval> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            Interval a = A[i], b = B[j];
            if (a.start > b.end) {
                j++;
            } else if (a.end < b.start) {
                i++;
            } else {
                int start = Math.max(a.start, b.start);
                int end = a.end;
                if (a.end > b.end) {
                    end = b.end;
                    j++;
                    //更新a，用于下次匹配
                    a.start = b.end + 1;
                } else if (a.end < b.end){
                    i++;
                    //更新b，用于下次匹配
                    b.start = a.end + 1;
                } else {
                    i++;
                    j++;
                }
                Interval c = new Interval(start, end);
                list.add(c);
            }
        }
        return list.toArray(new Interval[list.size()]);
    }
}