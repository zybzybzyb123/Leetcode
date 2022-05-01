/**
 * 前缀和
 * 关键是负数取余对应的是负数要加K
 */

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] cnt = new int[K + 1];
        int ans = 0;
        int sum = 0;
        cnt[0] = 1;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            // java余数为负数
            ans += cnt[(sum % K + K) % K]++;
        }
        return ans;
    }
}