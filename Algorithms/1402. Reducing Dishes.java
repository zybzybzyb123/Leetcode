/**
 * 看到这个题首先就知道n^2可以秒杀,顿了下感觉是可以n解决的
 * 排序从后往前累加,因为右边的和每次都会累加,边界就是sum < 0
 */
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0, ans = 0;
        for (int i = satisfaction.length - 1; i >= 0 ; i--) {
            sum += satisfaction[i];
            if (sum < 0) {
                break;
            }
            ans += sum;
        }
        return ans;
    }
}