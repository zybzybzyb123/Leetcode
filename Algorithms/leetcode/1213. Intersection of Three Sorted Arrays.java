/**
 * 三个指针利用数组有序的特性,空间复杂度O(1)
 */
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 0, k = 0; i < arr1.length && j < arr2.length && k < arr3.length; ) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                int maxVal = Math.max(arr1[i], Math.max(arr2[j], arr3[k]));
                if (arr1[i] < maxVal) {
                    i++;
                }
                if (arr2[j] < maxVal) {
                    j++;
                }
                if (arr3[k] < maxVal) {
                    k++;
                }
            }
        }
        return ans;
    }
}