/**
 * 用全局变量感觉难度就是一道medum
 * 维护左右的最大值, 每次都计算是不是最大和
 */
class Solution {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftRes = Math.max(maxPathSumHelper(root.left), 0);
        int rightRes = Math.max(maxPathSumHelper(root.right), 0);
        // 更新最大和
        ans = Math.max(leftRes + rightRes + root.val, ans);
        // 保留左右子树的最大和
        return Math.max(leftRes, rightRes) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return ans;
    }
}