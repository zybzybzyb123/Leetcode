/**
 * 统计每一列是否满足有序，不满足就删除
 */

class Solution {
    public int minDeletionSize(String[] A) {
        if (A.length == 1) return 0;
        int ans = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}