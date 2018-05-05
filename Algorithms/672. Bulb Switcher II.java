/**
 * 找规律题目，理解题意有点偏差，
 * 想了一下才发现，这个状态是不包含中间过程出现的状态
 */
class Solution {
    public int flipLights(int n, int m) {
        if (m == 0 || n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return m == 1 ? 3 : 4;
        if (m == 1) return 4;
        return m == 2 ? 7 : 8;
    }
}