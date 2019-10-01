/**
 * 注意下负数就好了
 */

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] cnt = new int[2002];
        boolean[] vis = new boolean[2002];
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i] + 1001]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (vis[cnt[i]]) {
                return false;
            }
            vis[cnt[i]] = true;
        }
        return true;
    }
}