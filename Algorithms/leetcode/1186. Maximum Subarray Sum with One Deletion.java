/**
 * 最大连续子数组的一个简单改造,核心就是计算左边和右边的和
 * 先计算出不删除的情况,之后再对每个位置删除这个数更新最大值
 */

class Solution {
    private int getMaxSubArraySum(int[] arr, int[] maxLArray, int[] maxRArray) {
        int curL = 0, curR = 0, maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int newLValue = arr[i] + curL;
            int newRValue = arr[arr.length - 1 - i] + curR;
            if (newLValue > maxValue) {
                maxValue = newLValue;
            }
            curL = newLValue > 0 ? newLValue : 0;
            curR = newRValue > 0 ? newRValue : 0;
            maxLArray[i] = newLValue;
            maxRArray[i] = newRValue;
        }
        return maxValue;
    }
    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] maxArray1 = new int[arr.length], maxArray2 = new int[arr.length];
        int ans = getMaxSubArraySum(arr, maxArray1, maxArray2);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < 0) {
                int left = maxArray1[i - 1], right = maxArray2[arr.length - 2 - i];
                ans = Math.max(ans, left + right);
            }
        }
        return ans;
    }
}