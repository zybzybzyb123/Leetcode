/**
 * 简单树形dp
 * res[0]表示不选当前根结点 res[1]表示选当前根结点
 */

class Solution {
    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }
}