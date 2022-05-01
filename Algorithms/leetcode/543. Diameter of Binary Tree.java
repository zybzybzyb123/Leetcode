/**
 * 最大深度的简单变形
 */
class Solution {
    private int ans = 0;
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth((root.left));
        int right = getMaxDepth(root.right);
        // 这里是包含根结点的,如果+1的话根结点会计算两次
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxDepth(root);
        return ans;
    }
}