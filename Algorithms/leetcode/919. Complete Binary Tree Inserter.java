/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 用一个数组维护完全二叉树的父子关系
 * 根节点从0开始，如果根节点为 i,
 * 左儿子为 2 * i,右儿子为 2 * i + 1
 */
class CBTInserter {

    private TreeNode head = null;
    private List<TreeNode> list = new ArrayList<>();
    public CBTInserter(TreeNode root) {
        this.head = root;
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public int insert(int v) {
        int sz = list.size();
        TreeNode root = list.get((sz - 1) / 2);
        if ((sz & 1) == 1) {
            root.left = new TreeNode(v);
            list.add(root.left);
        } else {
            root.right = new TreeNode(v);
            list.add(root.right);
        }
        return root.val;
    }

    public TreeNode get_root() {
        return head;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */