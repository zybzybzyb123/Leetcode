package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    private TreeNode buildTree(int[] pre, int l1, int r1, int[] post, int l2, int
            r2) {
        System.out.format("l1=%d, r1=%d, l2=%d, r2=%d\n", l1, r1, l2, r2);
        if (l1 == r1) {
            return null;
        }

        TreeNode root = new TreeNode(post[r2 - 1]);
        if (l1 == r1 - 2 && pre[l1] == post[l2]) {
            root.left = new TreeNode(pre[l1]);
            root.right = new TreeNode(pre[l1 + 1]);
            return root;
        }
        int id = r1 - 1;
        while (pre[id] != post[r2 - 1]) {
            //System.out.format("id : %d, val : %d\n", id, pre[id]);
            id--;
        }
        root.right = buildTree(pre, id + 1, r1, post,l2 + id - l1, r2 - 1);
        System.out.format("root=%d\n", root.val);
        System.out.format("l1=%d, r1=%d, l2=%d, r2=%d, id=%d\n", l1, r1, l2, r2, id);
        root.left = buildTree(pre, l1, id, post, l2, l2 + id - l1);
        return root;
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre, 0, pre.length, post, 0, post.length);
    }
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int leftNum = 1, cur = 0;
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            leftNum--;
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                cur++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                cur++;
            }
            if (leftNum == 0) {
                if (cur > 0) {
                    leftNum = cur;
                    cur = 0;
                }
                System.out.println(Arrays.toString(list.toArray()));
                list = new ArrayList<>();
            }
        }
    }
    public void preOrder(TreeNode root) {
        System.out.println(root.val);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
        int[] pre = {1,2,4,5,3,6,7}, post = {4,5,2,6,7,3,1};
        //int[] pre = {1,2,3}, post = {2,3,1};
        //TreeNode treeNode = solution.constructFromPrePost(pre, post);
        //solution.bfs(treeNode);
        //solution.preOrder(treeNode);
        int[] A = {1, 2, 3, 4};
        String str = "";
        str.toLowerCase();
        System.out.println(solution);
    }
}
