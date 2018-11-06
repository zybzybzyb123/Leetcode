package Leetcode;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = piles.length - 1; i >= 0; i--) {
            for (int j = i; j < piles.length; j++) {
                if (i == j) {
                    dp[i][j] = piles[i];
                } else {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1] );
                }
            }
        }
        return dp[0][piles.length - 1] > 0;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        int[] array = new int[]{1,2,3,4};
        Solution solution = new Solution();
        System.out.println(solution.stoneGame(array));
    }
}
