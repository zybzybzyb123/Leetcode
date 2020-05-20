/**
 * 子树传递从根到当前节点路径的最大值
 */

class Solution {
    private int goodNodesHelper(int maxVal, TreeNode root) {
        int ans = maxVal <= root.val ? 1 : 0;
        maxVal = Math.max(root.val, maxVal);
        if (root.left != null) {
            ans += goodNodesHelper(maxVal, root.left);
        }
        if (root.right != null) {
            ans += goodNodesHelper(maxVal, root.right);
        }
        return ans;
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return goodNodesHelper(root.val, root);
    }
}