//合并树有的节点存在两个指向他的父节点
//最好new TreeNode(t1.val),继续递归处理他的子节点
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        } else if(t1 == null){
            return t2;
        } else if(t2 == null){
            return t1;
        } else{
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        }
    }
}