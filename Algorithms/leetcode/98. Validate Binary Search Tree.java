/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidHelper(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (lower >= root.val) {
            return false;
        }
        if (upper <= root.val) {
            return false;
        }
        if (!isValidHelper(root.left, lower, root.val)) {
            return false;
        }
        if (!isValidHelper(root.right, root.val, upper)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}