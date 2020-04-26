/**
 * 签到题,预处理左前缀和右前缀可以一次遍历O(n)解决
 */

class Solution {

    public int maxScore(String s) {

        char[] array = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < array.length; i++) {
            int res = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] == '0') {
                    res++;
                }
            }
            for (int j = i; j < array.length; j++) {
                if (array[j] == '1') {
                    res++;
                }
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }
}