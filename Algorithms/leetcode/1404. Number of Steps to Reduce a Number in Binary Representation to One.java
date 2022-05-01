/**
 * 模拟大数进位,奇数+2,偶数+1
 */

class Solution {
    public int numSteps(String s) {
        char[] array = s.toCharArray();
        int ans = 0, flag = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int val = array[i] - '0';
            if (i == 0 && flag == 0) {
                break;
            }
            if ((val + flag) % 2 == 0) {
                ans++;
            } else {
                flag = 1;
                ans += 2;
            }
        }
        return ans;
    }
}