/**
 * 滑动窗口的基础题,超过阈值直接丢弃前面的(还要多练,代码可以简化很多)
 */

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cnt = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i), cht = t.charAt(i);
            cnt[i] = Math.abs(chs - cht);
        }
        int ans = 0, begin = -1, cur = 0;
        for (int i = 0; i < cnt.length; i++) {
            cur += cnt[i];
            if (cur > maxCost) {
                for (int j = begin + 1; j <= i; j++) {
                    cur -= cnt[j];
                    if (cur <= maxCost) {
                        begin = j;
                        ans = Math.max(ans, i - begin);
                        break;
                    }
                }
            } else {
                ans = Math.max(ans, i - begin);
            }
        }
        return ans;
    }
}