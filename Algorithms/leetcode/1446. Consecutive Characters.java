/**
 * O(n)
 */

class Solution {
    public int maxPower(String s) {
        char pre = '*';
        int ans = 1, cur = 0;
        for (char ch : s.toCharArray()) {
            if (ch != pre) {
                pre = ch;
                cur = 1;
            } else {
                ans = Math.max(ans, ++cur);
            }
        }
        return ans;
    }
}