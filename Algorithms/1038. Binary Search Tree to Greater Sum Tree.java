/**
 * 关键是题意没看懂，看懂了就是一个简单变形的中序遍历
 * 不过变成右根左而已，保存前面的和，加上当前节点的值就是新的值
 */


class Solution {
    private int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (null == root) {
            return null;
        }
        if (root.right != null) {
            bstToGst(root.right);
        }
        val += root.val;
        root.val = val;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }
}