class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) return 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int tot = A[i] + B[j];
                int cnt = map.getOrDefault(tot, 0);
                map.put(tot, cnt + 1);
            }
        }
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int tot = C[i] + D[j];
                int cnt = map.getOrDefault(-tot, 0);
                ans += cnt;
            }
        }
        return ans;
    }
}