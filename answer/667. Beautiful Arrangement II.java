class Solution {
    public int[] constructArray(int n, int k) {
        if(n == 2) return new int[]{1, 2};
        int[] ans = new int[n];
        int left = 1, right = n, id = 0;
        while(k > 2){
            k -= 2;
            ans[id++] = left++;
            ans[id++] = right--;
        }
        while(left <= right){
            ans[id++] = left++;
        }
        if(k == 2){
            int temp = ans[n - 1];
            ans[n - 1] = ans[n - 2];
            ans[n - 2] = temp;
        }
        return ans;
    }
}