/**
 * 比赛的时候直接O(n^2)过了,其实利用单调性进行二分优化到O(n*logn)
 */

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            //这里可以二分优化为logn
            for (int j = 1; j <= 1000; j++) {
                int res = customfunction.f(i, j);
                if (res >= z) {
                    if (res == z) {
                        ans.add(Arrays.asList(i, j));
                    }
                    break;
                }
            }
        }
        return ans;
    }
}