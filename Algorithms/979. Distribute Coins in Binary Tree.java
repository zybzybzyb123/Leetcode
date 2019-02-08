/**
 * 之前看了下还一下没想出来，过年没事瞅了瞅一下就想通了
 * 其实本质就是一个后续遍历，先处理子节点再处理父节点，
 * 只要当前节点的值不是1，就调整到1，把差值转移到父节点
 */

class Solution {
    public int postOrder(TreeNode parent, TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += postOrder(root, root.left);
        }
        if (root.right != null) {
            ans += postOrder(root, root.right);
        }
        if (root.val != 1 && parent != null) {
            ans += Math.abs(root.val - 1);
            parent.val += root.val - 1;
        }
        return ans;
    }
    public int distributeCoins(TreeNode root) {
        return postOrder(null, root);
    }
}