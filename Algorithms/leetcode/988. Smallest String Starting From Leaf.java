/**
 * 就是无脑递归，注意边界就没问题了
 */

class Solution {
    public String smallestFromLeaf(TreeNode root) {
        char end = (char) ('a' + root.val);
        if (root.left == null && root.right == null) {
            return new Character(end).toString();
        }
        if (root.left == null) {
            return smallestFromLeaf(root.right) + end;
        }
        if (root.right == null) {
            return smallestFromLeaf(root.left) + end;
        }
        String left = smallestFromLeaf(root.left);
        String right = smallestFromLeaf(root.right);
        return (left.compareTo(right) < 0  ? left : right) + end;
    }
}