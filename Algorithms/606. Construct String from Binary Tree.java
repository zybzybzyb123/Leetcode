/**
 * 关键点就是右子树存在左子树为null也要打印
 */
class Solution {
    private void dfs(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        }
        res.append(root.val);
        if (root.left != null || root.right != null) {
            res.append("(");
            dfs(root.left, res);
            res.append(")");
        }
        if (root.right != null) {
            res.append("(");
            dfs(root.right, res);
            res.append(")");
        }
    }
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        dfs(t, res);
        return res.toString();
    }
}