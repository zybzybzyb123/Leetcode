/**
 * 周赛又１题滚出，感觉递归是自己的短板，准备专项训练一波
 * 先贴个自己比较笨的解法，看了讨论区感觉到了和大佬们智商上的
 * 差距
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
    private static Map<Integer, List<TreeNode>> nodes = new HashMap<>();
    private static Map<TreeNode, TreeNode> rootNode = new HashMap<>();
    private int getDepth(TreeNode preNode, TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        rootNode.put(root, preNode);
        List<TreeNode> list = nodes.getOrDefault(depth, new ArrayList<>());
        list.add(root);
        nodes.put(depth, list);
//        nodes.putIfAbsent(depth, new ArrayList<>()).add(root);
//        nodes.get(depth);
        if (root.left == null && root.right == null) {
            return 0;
        }
        return Math.max(getDepth(root, root.left, depth + 1),
                getDepth(root, root.right, depth + 1)) + 1;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        nodes = new HashMap<>();
        rootNode = new HashMap<>();
        int d = getDepth(null, root, 0);
        // System.out.println(d);
        List<TreeNode> list = nodes.getOrDefault(d, new ArrayList<>());
        // System.out.println(list.size());
        if (list.size() == 1) {
            return list.get(0);
        }
        TreeNode ans = null;
        int curDep = d;
//        System.out.println(d);
        Set<TreeNode> set = new HashSet<>();
//        System.out.println(list.stream().map(node -> node.val).collect(toList()));
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            int cnt = d;
            do {
                if (set.contains(node) && cnt <= curDep) {
                    curDep = cnt;
                    ans = node;
                    set.add(node);
                    break;
                }
                set.add(node);
                cnt--;
                node = rootNode.get(node);
            } while (node != null);
        }
        return ans;
    }
}

/**
 *  可以根据深度判断，深度一样的就直接返回根节点
 */
class Solution {
    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    private TreeNode helper(TreeNode root, int d) {
        if (root == null) return null;
        if (d == 1) return root;
        TreeNode L = helper(root.left, d - 1), R = helper(root.right, d - 1);
        if (L != null && R != null) return root;
        return L == null ? R : L;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int d = getMaxDepth(root);
        return helper(root, d);
    }
}