/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 感觉这道题给的二叉搜索树这个条件不是
 * 很好利用，只能小小的优化一下
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null || L > R) return 0;
        int ans = 0;
        if (root.val >= L && root.val <= R) {
            ans = root.val;
        }
        if (root.val > L && root.left != null) {
            ans += rangeSumBST(root.left, L, R);
        }
        if (root.val < R && root.right != null) {
            ans += rangeSumBST(root.right, L, R);
        }
        return ans;
    }
}