/**
 * 题意看了好久才看明白。。。，每次可以移除同一行或者
 * 同一列的一块石头，问最多可以移除多少次
 * 抽象可知每个大小为n的连通集都可以移除n - 1次
 * 其实就是计算连通集的数目，比较适合并查集，其他见注释
 */

class Solution {
    private int[] par = new int[20005];
    //找根节点
    private int find(int a) {
        while(par[a] >= 0) {
            a = par[a];
        }
        return a;
    }
    private void link(int a, int b) {
        int a1 = find(a);
        int b1 = find(b);
        if (a1 == b1) {
            return;
        }
        //a1位根的集合更大，b1往a1合并
        if (par[a1] <= par[b1]) {
            par[a1] += par[b1];
            //路径压缩
            do {
                int t = par[b];
                par[b] = a1;
                b = t;
            } while (b >= 0);
        } else {
            par[b1] += par[a1];
            do {
                int t = par[a];
                par[a] = b1;
                a = t;
            } while (a >= 0);
        }
    }

    public int removeStones(int[][] stones) {
        //初始都为-1
        Arrays.fill(par, -1);
        for (int i = 0; i < stones.length; i++) {
            link(stones[i][0], stones[i][1] + 10000);
        }
        int ans = 0;
        for (int i = 0; i < stones.length; i++) {
            if (par[stones[i][0]] < 0) {
                ans++;
                par[stones[i][0]] = 0;
            }
            if (par[stones[i][1] + 10000] < 0) {
                ans++;
                par[stones[i][1] + 10000] = 0;
            }
        }
        return stones.length - ans;
    }
}