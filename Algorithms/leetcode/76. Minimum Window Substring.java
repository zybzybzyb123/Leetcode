/**
 * 经典滑动窗口
 */

class Solution {
    public String minWindow(String s, String t) {
        int[] cntT = new int[256];
        int[] cntS = new int[256];
        int totT = 0, totS = 0, len = s.length() + 1;
        String ans = "";
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            cntT[ch]++;
            if (cntT[ch] == 1) {
                totT++;
            }
        }
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            cntS[ch]++;
            if (cntS[ch] == cntT[ch]) {
                totS++;
            }
            // 等号很重要
            while (i <= j && totS == totT) {
                if (len > j - i + 1) {
                    len = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
                char cur = s.charAt(i);
                cntS[cur]--;
                if (cntS[cur] == cntT[cur] - 1) {
                    totS--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}