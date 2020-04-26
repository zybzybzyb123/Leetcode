/**
 * 就是统计不同数的个数(证明待定)
 */

class Solution {
    public int expectNumber(int[] scores) {
        int[] cnt = new int[1_000_001];
        int ans = 0;
        for (int score : scores) {
            if (cnt[score] == 0) {
                ans++;
                cnt[score]++;
            }
        }
        return ans;
    }
}