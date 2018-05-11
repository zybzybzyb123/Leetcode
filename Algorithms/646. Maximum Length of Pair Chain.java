/**
 * 之前用map搞的dp，打败2%，参考讨论区用数组重新实现dp
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 1) return 1;
        Arrays.sort(pairs, (o1, o2) -> {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
        });
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            int temp = pairs[i][0];
            for(int j = 0; j < i; j++){
                dp[i] = Math.max(dp[i], pairs[j][1] < temp ? dp[j] + 1 : dp[j]);
            }
        }
        return dp[n - 1];
    }
}