/**
 * 基数排序
 */
class Solution {
    public int countLargestGroup(int n) {
        int[] cnt = new int[40];
        for (int i = 1; i <= n ; i++) {
            int temp = i;
            int sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            cnt[sum]++;
        }
        int maxValue = 0;
        int ans = 0;
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] > maxValue) {
                maxValue = cnt[i];
                ans = 1;
            } else if (cnt[i] == maxValue) {
                ans++;
            }
        }
        return ans;
    }
}