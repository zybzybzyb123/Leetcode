/**
 * O(N^2)解法.可以用树状数组或者线段数优化到O(N*logN)
 */

class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        for (int j = 1; j < rating.length - 1; j++) {
            int lessI = 0;
            int lessK = 0;
            int moreI = 0;
            int moreK = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] > rating[j]) {
                    moreI++;
                } else {
                    lessI++;
                }
            }
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[k] > rating[j]) {
                    moreK++;
                } else {
                    lessK++;
                }
            }
            ans += lessI * moreK + lessK * moreI;
        }
        return ans;
    }
}