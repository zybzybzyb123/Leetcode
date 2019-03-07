/**
 * 简单递归，找到比根节点大的就是右子树，其他就是左子树
 */

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
    private TreeNode helper(int[] preorder, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[begin]);
        int pos = begin + 1;
        while (pos < end) {
            if (preorder[pos] > preorder[begin]) {
                break;
            }
            pos++;
        }
        root.left = helper(preorder, begin + 1, pos);
        root.right = helper(preorder, pos, end);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length);
    }
}