/**
 * 基数排序思想
 */

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int cnt[] = new int[1005];
        for (int i = 0; i < arr1.length; i++) {
            cnt[arr1[i]]++;
        }
        int id = 0;
        for (int i = 0; i < arr2.length; i++) {
            int value = arr2[i];
            while (cnt[value]-- > 0) {
                ans[id++] = value;
            }
        }
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            int value = arr1[i];
            while (cnt[value]-- > 0) {
                ans[id++] = value;
            }
        }
        return ans;
    }
}