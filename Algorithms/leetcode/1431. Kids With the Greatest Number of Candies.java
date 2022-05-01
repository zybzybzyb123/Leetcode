/**
 * 求个最大值
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxVal = 0;
        for (int candie : candies) {
            maxVal = Math.max(maxVal, candie);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int candie : candies) {
            ans.add(candie + extraCandies >= maxVal);
        }
        return ans;
    }
}