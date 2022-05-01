/**
 * 递归水题
 */

class Solution {
    public int kthGrammar(int N, int K) {
        if  (K == 1) {
            return 0;
        }
        int val = kthGrammar(N - 1, (K + 1) / 2);
        if  (val == 0) {
            return (K & 1) == 1 ? 0 : 1;
        }
        return (K & 1) == 1 ? 1 : 0;
    }
}