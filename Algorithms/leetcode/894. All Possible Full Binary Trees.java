/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 递归是解决这道题最无脑的方法了，不过个人感觉不太优雅
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        if ((N & 1) == 0) return new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> list1 = allPossibleFBT(i);
            List<TreeNode> list2 = allPossibleFBT(N - 1 - i);
            for (TreeNode left : list1) {
                for (TreeNode right : list2) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}