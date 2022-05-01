/**
 * 异或状态压缩, 记录第一个标志位置
 */

class Solution {
    public int findTheLongestSubstring(String s) {
        int ans = 0;
        int flag = 0;
        int n = s.length();
        // 这可以优化, 不过就这样吧, 看着舒服点
        String str = "aeiou";
        int[] firstPos = new int[1 << 5];
        Arrays.fill(firstPos, -1);
        firstPos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = str.indexOf(ch);
            if (index >= 0) {
                flag ^= (1 << index);
            }
            if (firstPos[flag] >= 0) {
                ans = Math.max(ans, i + 1 - firstPos[flag]);
            } else {
                firstPos[flag] = i + 1;
            }
        }
        return ans;
    }
}