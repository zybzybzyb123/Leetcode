/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 就是二叉搜索树的性质，水题一道
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode node = root;
        while (true) {
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                }
                node = node.left;
            }
        }
        return root;
    }
}