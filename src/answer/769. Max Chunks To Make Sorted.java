class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(1 == arr.length) return 1;
        int ans = 0, Max = -1;
        for(int i = 0; i < arr.length; i++){
            Max = Math.max(Max, arr[i]);
            if(Max == i){
                ans++;
            }
        }
        return ans;
    }
}