/**
 * 比赛的时候直接无脑写了个O(n ^ 2)的解法
 * 后来想了下其实O(n)就行了,遍历判断奇数和偶数的次数取小的就好了
 */

class Solution {
    public int minCostToMoveChips(int[] chips) {
        int ans = 0;
        for (int i = 0; i < chips.length; i++) {
            if ((chips[i] & 1) == 1) {
                ans++;
            }
        }
        return Math.min(ans, chips.length - ans);
    }
}