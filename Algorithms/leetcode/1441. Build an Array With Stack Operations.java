/**
 * 简单模拟
 */
class Solution {

    public List<String> buildArray(int[] target, int n) {
        int id = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n && id < target.length; i++) {
            ans.add("Push");
            if (target[id] == i) {
                id++;
            } else {
                ans.add("Pop");
            }
        }
        return ans;
    }
}