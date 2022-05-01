/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 层次遍历，用堆的性质，堆节点编号，同一层最
 * 右边减去最左边的编号就是当层的宽度
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return  0;
        int leftNum = 1, cur = 0, ans = 0, begin = 1;
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);
        while(!queue.isEmpty()) {
            leftNum--;
            TreeNode temp = queue.poll();
            if (flag) {
                flag = false;
                begin = temp.val;
            }
            if (temp.left != null) {
                temp.left.val = 2 * temp.val;
                queue.offer(temp.left);
                cur++;
            }
            if (temp.right != null) {
                temp.right.val = 2 * temp.val + 1;
                queue.offer(temp.right);
                cur++;
            }
            if (leftNum == 0) {
                ans = Math.max(ans, temp.val - begin + 1);
                if (cur > 0) {
                    leftNum = cur;
                    cur = 0;
                    flag = true;
                }
            }
        }
        return ans;
    }
}