class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int ans = 0;
        int[][] cnt = new int[1005][2];
        for (int i = 0; i < trips.length; i++) {
            cnt[trips[i][1]][0] += trips[i][0];
            cnt[trips[i][2]][1] += trips[i][0];
        }
        for (int i = 0; i < 1005; i++) {
            if (cnt[i][0] + cnt[i][1] == 0) {
                continue;
            }
            ans += cnt[i][0] - cnt[i][1];
            if (ans > capacity) {
                return false;
            }
        }
        return true;
    }
}