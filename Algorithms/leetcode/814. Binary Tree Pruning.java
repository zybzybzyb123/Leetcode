/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 简单先序遍历就解决了
 */
class Solution {
    private TreeNode preOrder(TreeNode root){
        if(root.left != null){
            root.left = preOrder(root.left);
        }
        if(root.right != null){
            root.right = preOrder(root.right);
        }
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        return preOrder(root);
    }
}