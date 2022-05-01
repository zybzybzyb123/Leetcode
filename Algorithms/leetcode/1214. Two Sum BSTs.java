/**
 * 中序遍历两颗搜索二叉树
 */
class Solution {
    //中序遍历
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        }
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        //两个指针一个从前往后一个从后往前
        for (int i = 0, j = list2.size() - 1; i < list1.size() && j >= 0;) {
            int val = list1.get(i) + list2.get(j);
            if (val == target) {
                return true;
            } else if (val > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}