/**
 * 函数返回lastNode
 */
public class Solution {
    public TreeNode convertHelper(TreeNode root, TreeNode lastNode) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            lastNode = convertHelper(root.left, lastNode);
        }
        if (lastNode != null) {
            root.left = lastNode;
            lastNode.right = root;
        }
        lastNode = root;
        if (root.right != null) {
            lastNode = convertHelper(root.right, lastNode);
        }
        return lastNode;
    }

    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertHelper(root, null);
        TreeNode head = root;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
}