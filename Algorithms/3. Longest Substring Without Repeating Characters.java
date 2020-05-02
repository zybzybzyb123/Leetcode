/**
 * 滑动窗口
 */

class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int[] cnt = new int[256];
        int j = 0;
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            cnt[array[i]]++;
            while (cnt[array[i]] > 1) {
                cnt[array[j++]]--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}