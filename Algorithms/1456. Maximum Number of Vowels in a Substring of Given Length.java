/**
 * 简单滑动窗口
 */

class Solution {
    public int maxVowels(String s, int k) {
        char[] array = s.toCharArray();
        String str = "aeiou";
        int[] value = new int[26];
        for (char ch : str.toCharArray()) {
            value[ch - 'a'] = 1;
        }
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += value[array[i] - 'a'];
        }
        int ans = cnt;
        for (int i = k; i < array.length; i++) {
            cnt += value[array[i] - 'a'] - value[array[i - k] - 'a'];
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}