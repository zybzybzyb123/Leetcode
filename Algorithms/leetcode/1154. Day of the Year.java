/**
 * 核心就是判断闰年,其他没啥了
 */

class Solution {
    private boolean isLeap(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    private static int[] sum = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    public int dayOfYear(String date) {
        String[] array = date.split("-");
        int y = Integer.valueOf(array[0]), m = Integer.valueOf(array[1]),
                d = Integer.valueOf(array[2]);
        int ans = sum[m - 1] + d;
        if (m > 2 && isLeap(y)) {
            ans++;
        }
        return ans;
    }
}