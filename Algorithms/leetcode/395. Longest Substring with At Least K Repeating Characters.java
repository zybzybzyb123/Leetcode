/**
 * O(N ^ 2)的解法, 加了大量优化剪枝
 * 55ms -> 2ms
 */

class Solution {
    public int longestSubstring(String s, int k) {
        if (k <= 1) {
            return s.length();
        }
        char[] array = s.toCharArray();
        int[] vis = new int[26], sum = new int[26];
        for (char ch : array) {
            sum[ch - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < array.length && ans < array.length - i; i++) {
            if (sum[array[i] - 'a'] < k) {
                continue;
            }
            Arrays.fill(vis, 0);
            int cnt = 0;
            for (int j = i; j < array.length; j++) {
                int pos = array[j] - 'a';
                if (sum[pos] < k || array.length - i + 1 <= ans) {
                    break;
                }
                if (vis[pos] < k) {
                    if (vis[pos] == k - 1) {
                        cnt--;
                    } else if (vis[pos] == 0) {
                        cnt++;
                    }
                }
                vis[pos]++;
                if (cnt == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}