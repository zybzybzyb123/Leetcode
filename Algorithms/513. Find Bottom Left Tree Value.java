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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int cur = 0, leftNum = 1, ans = root.val;
        queue.offer(root);
        while(!queue.isEmpty()){
            leftNum--;
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                cur++;
            }
            if(node.right != null){
                queue.offer(node.right);
                cur++;
            }
            if(0 == leftNum && cur > 0){
                leftNum = cur;
                cur = 0;
                ans = queue.peek().val;
            }
        }
        return ans;
    }
}