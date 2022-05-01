/**
 * 经典dp题目，我是这个思路dp[i]表示开始到当前位置的最小值
 * 如果当前值在数据集里就取三种方式的最小值
 *  dp[i] = Math.min(costs[j] + dp[i - sep[j]], dp[i])
 *  不在数据集
 *  dp[i] = dp[i - 1];
 */

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 1) {
            return Math.min(Math.min(costs[0], costs[1]), costs[2]);
        }
        int[] sep = {1, 7, 30};
        boolean[] vis = new boolean[366];
        for (int i = 0; i < days.length; i++) {
            vis[days[i]] = true;
        }
        int start = days[0], end = days[days.length - 1];
        int[] dp = new int[366];
        dp[start] = Math.min(Math.min(costs[0], costs[1]), costs[2]);
        for (int i = start + 1; i <= end; i++) {
            //在数据集
            if (vis[i]) {
                dp[i] = 365000;
                for (int j = 0; j < 3; j++) {
                    if (i - sep[j] < start) {
                        //开始区间只有一段
                        dp[i] = Math.min(costs[j], dp[i]);
                    } else {
                        dp[i] = Math.min(costs[j] + dp[i - sep[j]], dp[i]);
                    }
                }
            } else {
                //不在数据集取前一个值
                dp[i] = dp[i - 1];
            }
        }
//        for (int i = start; i <= end; i++) {
//            System.out.format("dp[%d] = %d\n", i, dp[i]);
//        }
        return dp[end];
    }
}