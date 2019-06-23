/**
 * 感觉空间是可以省掉的
 */
class Solution {
    public void duplicateZeros(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt++;
            }
        }
        if (cnt == 0) {
            return;
        }
        int[] res = new int[arr.length];
        int id = 0;
        for (int i = 0; i < arr.length && id < arr.length; i++) {
            res[id++] = arr[i];
            if (arr[i] == 0 && id < arr.length) {
                res[id++] = 0;
            }
        }
        for (int i = 0; i < res.length; i++) {
            arr[i] = res[i];
        }
    }
}