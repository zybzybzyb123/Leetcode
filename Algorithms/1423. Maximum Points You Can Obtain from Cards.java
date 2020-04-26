/**
 * 反过来算就好了,最后剩下的肯定是一个 len - k长的连续串,
 * 只要保证这个串的和最小就行了
 */

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int kSum = 0;

        k = cardPoints.length - k;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
            kSum += cardPoints[i];
        }
        int minValue = kSum;
        for (int i = k; i < cardPoints.length; i++) {
            sum += cardPoints[i];
            kSum += cardPoints[i] - cardPoints[i - k];
            minValue = Math.min(minValue, kSum);
        }
        return sum - minValue;
    }
}