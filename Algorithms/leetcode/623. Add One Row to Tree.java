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
 * 层次遍历简单变化，记录上一层的节点数和当前层级
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1, leftNum = 1, cur = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            leftNum--;
            if(node.left != null){
                queue.offer(node.left);
                cur++;
            }
            if(node.right != null){
                queue.offer(node.right);
                cur++;
            }
            if(level == d - 1){
                TreeNode newLeft = new TreeNode(v);
                newLeft.left = node.left;
                node.left = newLeft;
                TreeNode newRight = new TreeNode(v);
                newRight.right = node.right;
                node.right = newRight;
            }
            if(leftNum == 0 && cur > 0){
                leftNum = cur;
                level++;
                cur = 0;
            }
        }
        return root;
    }
}