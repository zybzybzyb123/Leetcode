/**
 * 这个题应该是有更优的解法的，理论上是可以直接找到最后一个
 * 循环的条件，不过累加的复杂度sqrt(n)已经够用了
 */

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        for (int i = 0; candies > 0; i++) {
            int value = Math.min(candies, i + 1);
            ans[i % num_people] += value;
            candies -= value;
        }
        return ans;
    }
}