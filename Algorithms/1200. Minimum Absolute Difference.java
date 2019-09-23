/**
 * 排序处理就行了
 */

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minVal = 2_000_001;
        for (int i = 1; i < arr.length; i++) {
            int curVal = arr[i] - arr[i - 1];
            if (curVal < minVal) {
                minVal = curVal;
                ans.clear();
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (curVal == minVal) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }
}