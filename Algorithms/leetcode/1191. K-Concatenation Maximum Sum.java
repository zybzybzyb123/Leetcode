/**
 * 周赛没做出来，下来半个小时解决了
 * 这个题其实只和三个序列有关,针对k <= 2的直接计算
 * k > 2的如果和小于等于0就计算连续三个就好了
 * sum大于0的再加上 (k - 2) * sum
 */

class Solution {
    private long getMaxSubArraySum(int[] arr, int k) {
        int cur = 0;
        long maxValue = 0;
        for (int i = 0; i < arr.length * k; i++) {
            int id = i % arr.length;
            int newValue = arr[id] + cur;
            if (newValue > maxValue) {
                maxValue = newValue;
            }
            cur = newValue > 0 ? newValue : 0;
        }
        return maxValue;
    }
    private static final int MOD = 1_000_000_000 + 7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        for (int val : arr) {
            sum += val;
        }
        //和小于0肯定不是一个序列内就是两边的拼接,计算三个是可以覆盖的
        if (k <= 2 || sum <= 0) {
            return (int) (getMaxSubArraySum(arr, Math.min(k, 2)) % MOD);
        }
        //和大于0的再把循环部分的和加上就好了
        return (int) ((getMaxSubArraySum(arr, 2) + (k - 2) * sum) % MOD);
    }
}