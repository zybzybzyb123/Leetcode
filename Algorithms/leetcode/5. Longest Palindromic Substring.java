/**
 * O(n ^ 2)的解法 处理奇数和偶数串
 */

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] array = s.toCharArray();
        int maxLen = 1;
        String ans = s.substring(0, 1);
        for (int i = 0; i < array.length; i++) {
            for (int j = i - 1, k = i + 1; j >= 0 && k < array.length; j--, k++) {
                if (array[j] != array[k]) {
                    break;
                }
                if (maxLen < k - j + 1) {
                    maxLen = k - j + 1;
                    ans = s.substring(j, k + 1);
                }
            }
            if (i > 0 && array[i] == array[i - 1]) {
                if (maxLen < 2) {
                    maxLen = 2;
                    ans = s.substring(i - 1, i + 1);
                }
                for (int j = i - 2, k = i + 1; j >= 0 && k < array.length; j--, k++) {
                    if (array[j] != array[k]) {
                        break;
                    }
                    if (maxLen < k - j + 1) {
                        maxLen = k - j + 1;
                        ans = s.substring(j, k + 1);
                    }
                }
            }
        }
        return ans;
    }
}