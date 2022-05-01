class Solution {
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];
        long sum = 0;
        int numCnt = 0, minVal = -1, perCnt = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (minVal == -1) {
                    minVal = i;
                    ans[0] = i;
                }
                if (count[i] > perCnt) {
                    perCnt = count[i];
                    ans[4] = i;
                }
                ans[1] = i;
                numCnt += count[i];
                sum += count[i] * i;
            }
        }
        boolean isOdds = numCnt % 2 == 1;
        int middle = (numCnt + 1) / 2;
        int val = 0;
        for (int i = 0; i < count.length; i++) {
            if (middle > count[i]) {
                middle -= count[i];
                continue;
            } else {
                if (isOdds || middle < count[i]) {
                    ans[3] = val > 0 ? (val + i) / 2.0 : i;
                    break;
                } else {
                    val += i;
                    middle = 0;
                    isOdds = true;
                }
            }
        }
        ans[2] = sum * 1.0 / numCnt;
        return ans;
    }
}