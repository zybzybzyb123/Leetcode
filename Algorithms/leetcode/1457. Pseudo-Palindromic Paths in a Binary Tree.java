/**
 * 先序遍历 中途统计奇数个数(小于等于1)
 */

class Solution {
    private int[] nums = new int[10];
    private int cntOdd = 0;
    private int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) {
            return 0;
        }
        nums[root.val] = 1 - nums[root.val];
        int delta = nums[root.val] == 1 ? 1 : -1;
        cntOdd += delta;
        if (root.left == null && root.right == null) {
            if (cntOdd <= 1) {
                ans++;
            }
        } else {
            if (root.left != null) {
                pseudoPalindromicPaths(root.left);
            }
            if (root.right != null) {
                pseudoPalindromicPaths(root.right);
            }
        }
        nums[root.val] = 1 - nums[root.val];
        cntOdd += -delta;
        return ans;
    }
}