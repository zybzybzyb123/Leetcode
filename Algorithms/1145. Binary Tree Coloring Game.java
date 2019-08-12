/**
 * 其实这个题的关键就是放好y就已经决定了两边的节点数
 * 所以说极值就在x的三个相连接端点处
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
    private int left, right, val;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        return Math.max(Math.max(left, right), n - 1 - left - right) > n / 2;
    }

    private int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left, x), r = dfs(root.right, x);
        if (x == root.val) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}