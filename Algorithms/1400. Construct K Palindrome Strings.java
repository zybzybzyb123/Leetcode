/**
 * 统计奇数字符出现的频次,这个是下限,上限就是字符串长度
 */
class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            ans += (cnt[i] & 1);
        }
        return k >= ans;
    }
}