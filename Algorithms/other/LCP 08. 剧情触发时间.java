/**
 * 二分法
 */
class Solution {
    private boolean isMoreThan(int[] cur, int[] requirement) {
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] < requirement[i]) {
                return false;
            }
        }
        return true;
    }
    private int binarySearch(int[][] array, int[] requirement) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isMoreThan(array[mid], requirement)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left >= array.length ? -1 : left;
    }

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[][] array = new int[increase.length + 1][3];
        for (int i = 0; i < increase.length; i++) {
            for (int j = 0; j < 3; j++) {
                array[i + 1][j] = array[i][j] + increase[i][j];
            }
        }
        int[] ans = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            int res = binarySearch(array, requirements[i]);
            ans[i] = res;
        }
        return ans;
    }
}