/**
 * 这个题卡了好久，之前一直以为是之前的算法有漏洞，今天仔细看
 * 才发现是递归左子树的右边界有问题，改完就过了
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre, 0, pre.length, post, 0, post.length);
    }

    private TreeNode buildTree(int[] pre, int preLeft, int preRight, int[] post, int postLeft, int
            postRight) {
//        System.out.format("preL1=%d, r1=%d, l2=%d, r2=%d\n", preL1, r1, l2, r2);
        if (preLeft >= preRight) {
            return null;
        }
        if (preLeft == preRight - 1) {
            return new TreeNode(pre[preLeft]);
        }

        TreeNode root = new TreeNode(pre[preLeft]);
        int id = postRight - 1;
        //找左根节点
        while (pre[preLeft + 1] != post[id]) {
            //System.out.format("id : %d, val : %d\n", id, pre[id]);
            id--;
        }
        //preLeft + 1 + (id + 1 - postLeft) (len)
        root.left = buildTree(pre, preLeft + 1, preLeft + id - postLeft + 2, post, postLeft, id +
                1);
        root.right = buildTree(pre, preLeft + id - postLeft + 2, preRight, post,id + 1, postRight
                - 1);
        return root;
    }
}