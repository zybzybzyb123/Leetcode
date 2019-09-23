/**
 * 经典递归就是提交了10次才通过,之后再试试
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
    private static int maxValue = 0;

    private int helper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int val1 = helper(root.left), val2 = helper(root.right);
        if (root.left != null && root.right != null) {
            if (root.left.val == root.val && root.right.val == root.val) {
                val1++;
                val2++;
                maxValue = Math.max(maxValue, val1 + val2);
                return Math.max(val1, val2);
            } else if (root.left.val == root.val) {
                val1++;
                maxValue = Math.max(maxValue, val1);
                return val1;
            } else if (root.right.val == root.val) {
                val2++;
                maxValue = Math.max(maxValue, val2);
                return val2;
            }
        } else if (root.left != null && root.left.val == root.val) {
            val1++;
            maxValue = Math.max(maxValue, val1);
            return val1;
        } else if (root.right != null && root.right.val == root.val) {
            val2++;
            maxValue = Math.max(maxValue, val2);
            return val2;
        }
        return 0;
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        maxValue = 0;
        helper(root);
        return maxValue;
    }
}