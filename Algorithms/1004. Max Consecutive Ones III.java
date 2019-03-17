/**
 * 滑动窗口，自己用数组简单模拟了一个队列，
 * 用一个假的初始0放在-1的位置，处理全数组都
 * 满足的情况
 */

class Solution {
    public int longestOnes(int[] A, int K) {
        int[] queue = new int[20005];
        int front = 0, tail = 1, ans = 0;
        //针对全数组的特殊处理
        queue[0] = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                queue[tail++] = i;
                if (K > 0) {
                    K--;
                } else {
                    front++;
                }
            }
            ans = Math.max(ans, i - queue[front]);
        }
        return ans;
    }
}