/**
 * 主注意边界, 递归
 */

class Solution {
    public TreeNode buildTreeHelper(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        // 处理边界
        if (l1 > r1) {
            return null;
        }
        int rootVal = preorder[l1];
        TreeNode root = new TreeNode(rootVal);
        int pos = l2;
        while (inorder[pos] != rootVal) {
            pos++;
        }
        root.left = buildTreeHelper(preorder, l1 + 1, l1 + pos - l2, inorder, l2, pos - 1);
        root.right = buildTreeHelper(preorder, l1 + pos - l2 + 1, r1, inorder, pos + 1, r2);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return buildTreeHelper(preorder, 0, len - 1, inorder, 0, len - 1);
    }
}