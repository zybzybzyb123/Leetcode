/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 先来个中序遍历再倒序更新值，提交打败22%。。。，
 * 写的时候感觉可以不用用list保存节点，看了
 * 讨论区豁然开朗，其实把中序遍历倒过来，每次
 * 更新节点值就OK了，不需要考虑节点之间的关系
 */
class Solution {
    int cur = 0;
    private void dfs(TreeNode root){
        if(root == null) return;
        if(root.right != null){
            dfs(root.right);
        }
        cur += root.val;
        root.val = cur;
        if(root.left != null){
            dfs(root.left);
        }
    }
    public TreeNode convertBST(TreeNode root) {
        if(null == root) return null;
        dfs(root);
        return root;
    }
}