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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int cur = 0, leftNum = 1, Max = Integer.MIN_VALUE;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            leftNum--;
            Max = Math.max(Max, node.val);
            if(node.left != null){
                queue.offer(node.left);
                cur++;
            }
            if(node.right != null){
                queue.offer(node.right);
                cur++;
            }
            if(leftNum == 0){
                if(cur > 0){
                    leftNum = cur;
                    cur = 0;   
                }
                ans.add(Max);
                Max = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}