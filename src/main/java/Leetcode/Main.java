//CHECKSTYLE:OFF
package Leetcode;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    public int matrixScore(int[][] A) {
        int n = A.length, m = A[0].length;
        int ans = (1 << (n - 1)) * n;
        for (int j = 1; j < m; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (A[i][j] == 0) {
                    cnt++;
                }
            }
            ans += (1 << (n - 1 - j)) * Math.max(cnt, n - cnt);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
    }
}
