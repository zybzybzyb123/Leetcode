/**
 *  水一道题，一种是计算再排序，
 *  一种是先算绝对值出现次数，桶的思想
 */

class Solution {
    public int[] sortedSquares1(int[] A) {
        int[] cnt = new int[10001];
        for (int val : A) {
            cnt[val < 0 ? -val : val]++;
        }
        int id = 0;
        for (int i = 0; i < 10001; i++) {
            while (cnt[i]-- > 0) {
                A[id++] = i * i;
            }
        }
        return A;
    }

    public int[] sortedSquares2(int[] A) {
        int[] cnt = new int[10001];
        for (int val : A) {
            cnt[val < 0 ? -val : val]++;
        }
        int id = 0;
        for (int i = 0; i < 10001; i++) {
            while (cnt[i]-- > 0) {
                A[id++] = i * i;
            }
        }
        return A;
    }
}