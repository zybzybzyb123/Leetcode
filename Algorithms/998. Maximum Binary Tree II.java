/**
 * 这道题真的看着有点蛋疼，题意理解就特别费劲
 * 提交了七发终于知道啥意思，就是说在根节点左边的是左子树，
 * 在右边的是右子树(左右是指在数组中的位置)。
 * 那么大体可以分出以下三种情况:
 * 1: 如果比根节点大，那么新节点就是根节点，旧根节点就是左节点
 * 如果比根节点小只能往右走(因为相对位置在右边)，这时还有两种情况:
 * 2: 如果比所有节点小，就挂在最后一个子节点的有节点
 * 3: 如果比某一个节点大，就插入其中，这时要注意，新节点位置代替旧结点，
 * 但是之前的节点要挂到新节点的左子树，具体可以看代码
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode head = root, par = null;
        //一直找比val小的节点
        while (head != null && head.val > val) {
            par = head;
            head = head.right;
        }
        TreeNode node = new TreeNode(val);
        //比根节点大
        if (par == null) {
            node.left = root;
            return node;
        } else {
            //比所有子节点小
            if (head == null) {
                node.right = par.right;
                par.right = node;
            } else {
                //比每一个节点大，插入其中
                node.left = par.right;
                par.right = node;
            }
        }
        return root;
    }
}