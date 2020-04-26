/**
 * 整体还是二分
 */

class Solution {
    private int calDays(int[] time, int n) {
        int ans = 0;
        for (int i = 0; i < time.length; ) {
            int sum = 0;
            int maxValue = 0;
            // 多加一个最大值,为求助同学
            while (i < time.length) {
                maxValue = Math.max(maxValue, time[i]);
                if (sum + time[i] > n + maxValue) {
                    break;
                } else {
                    sum += time[i++];
                }
            }
            ans++;
        }
        return ans;
    }

    public int minTime(int[] time, int m) {
        if (m >= time.length) {
            return 0;
        }
        int left = 1;
        int right = 1_000_000_000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int day = calDays(time, mid);
            if (day > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}