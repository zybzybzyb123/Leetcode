/**
 * 这水题居然是medium难度的。。。
 */
class Solution {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;
        int ans = 0, left = 0;
        for(char ch : S.toCharArray()) {
            if (ch == ')') {
                if (left == 0) {
                    ans++;
                } else {
                    left--;
                }
            } else {
                left++;
            }
        }
        return ans + left;
    }
}