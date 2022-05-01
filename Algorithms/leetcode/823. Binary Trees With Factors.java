/**
 * 基本dp，详细见代码注释
 */

class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        if(A.length == 1) return 1;
        Arrays.sort(A);
        int n = A.length;
        //dp数组可以理解为以A[i]为根节点的树的个数
        long dp[] = new long[n], ans = 0;
        int mod = (int)1e9 + 7;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(A[i], i);
        }
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = i - 1; j >= 0 && A[i] / A[j] <= A[j]; j--){
                if(A[i] % A[j] != 0){
                    continue;
                }
                //左右孩子相同就直接相加，不同需要乘2
                if(A[j] == A[i] / A[j]){
                    dp[i] += (dp[j] * dp[j]) % mod;
                } else if(pos.containsKey(A[i] / A[j])){
                    dp[i] += (2 * dp[j] * dp[pos.get(A[i] / A[j])]) % mod;
                }
            }
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }
}