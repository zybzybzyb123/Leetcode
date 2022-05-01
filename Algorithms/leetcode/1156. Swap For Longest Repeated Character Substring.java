/**
 * 滑动窗口的经典题目,之前理解的不够深入,之后再
 * 找几道类似的练习下
 */

class Solution {
    public int maxRepOpt1(String text) {
        char[] array = text.toCharArray();
        int[] cnt = new int[26], freq = new int[26];
        //ans表示当前窗口的最大值,cur用来记录当前最大窗口的字符
        int ans = 0, start = 0, cur = 0;
        for (int i = 0; i < array.length; i++) {
            int val = array[i] - 'a';
            cnt[val]++;
            if (++freq[val] > ans) {
                ans = freq[val];
                cur = val;
            }
            if (i - start + 1 > ans + 1) {
                freq[array[start++] - 'a']--;
            }
        }
        return Math.min(array.length - start, cnt[cur]);
    }
}