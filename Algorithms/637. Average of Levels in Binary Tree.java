/**
 * 层次遍历，记录当前层节点数和下一层的节点数
 */

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if(null == root) return new ArrayList<Double>();
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftNum = 1, cnt = 0, cur = 0;
        long sum = 0;
        while(!queue.isEmpty()){
            leftNum--;
            TreeNode node = queue.poll();
            sum += node.val;
            cnt++;
            if(node.left != null){
                queue.offer(node.left);
                cur++;
            }
            if(node.right != null){
                queue.offer(node.right);
                cur++;
            }
            if(leftNum == 0){
                ans.add(sum * 1.0 / cnt);
                sum = 0;
                cnt = 0;
                if(cur > 0){
                    leftNum = cur;
                    cur = 0;
                }
            }
        }
        return ans;
    }
}