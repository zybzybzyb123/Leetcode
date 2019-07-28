/**
 * 算法复杂度比较低，然而实际也就打败60%多，被穷举吊锤。。。
 * 参考了网上别人的思路，就是把两个数组中1的位置离散，求差值,
 * 差值可以理解为向量移动，相同差值越多表示这个移动相同的1越多
 */

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        Map<Integer, Integer> cnt = new HashMap<>();
        List<Integer> pos1 = new ArrayList<>();
        List<Integer> pos2 = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    pos1.add(i * 100 + j);
                }
                if (B[i][j] == 1) {
                    pos2.add(i * 100 + j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < pos1.size(); i++) {
            for (int j = 0; j < pos2.size(); j++) {
                //这是存在负数的，不然我就用数组了
                int key = pos2.get(j) - pos1.get(i);
                int val = cnt.getOrDefault(key,0);
                ans = Math.max(val + 1, ans);
                cnt.put(key, val + 1);
            }
        }
        return ans;
    }
}