package Leetcode;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//CHECKSTYLE:OFF
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
    public int longestSubstring(String s, int k) {
        return 0;
    }
    public int[] beautifulArray(int N) {
        return null;
    }
    public int largestOverlap(int[][] A, int[][] B) {
        int[] cnt = new int[2000];
        int len1 = 0, len2 = 0;
        System.out.format("A len : %d\n", A.length);
        int[] pos1 = new int[A.length * A.length + 10];
        int[] pos2 = new int[pos1.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    pos1[len1++] = i * 30 + j;
                }
                if (B[i][j] == 1) {
                    pos2[len2++] = i * 30 + j;
                }
            }
        }
        int ans = 0;
        System.out.format("len1 = %d, len2 = %d\n", len1, len2);
        System.out.format("pos1 = %s\n", Arrays.stream(pos1).limit(len1).boxed().collect(toList()));
        System.out.format("pos2 = %s\n", Arrays.stream(pos2).limit(len2).boxed().collect(toList()));
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
//                System.out.format("pos2[j] - pos1[i] = %d\n", pos2[j] - pos1[i]);
                cnt[pos2[j] - pos1[i] + 1000]++;
                ans = Math.max(cnt[pos2[j] - pos1[i] + 1000], ans);
            }
        }
        return ans;
    }

    public int largestOverlap1(int[][] A, int[][] B) {
        Map<Integer, Integer> cnt = new HashMap<>();
        List<Integer> pos1 = new ArrayList<>();
        List<Integer> pos2 = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    pos1.add(i * 32 + j);
                }
                if (B[i][j] == 1) {
                    pos2.add(i * 32 + j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < pos1.size(); i++) {
            for (int j = 0; j < pos2.size(); j++) {
                int key = pos2.get(j) - pos1.get(i);
                int val = cnt.getOrDefault(key,0);
                if (val == 481) {
                    System.out.printf("pos1 = %d, pos2 = %d\n", pos1.get(i), pos2.get(j));
                }
                ans = Math.max(val + 1, ans);
                cnt.put(key, val + 1);
            }
        }
        return ans;
    }

    public boolean isValid(String S) {
        LinkedList<Integer> stash = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            int val = ch - 'a';
            if (val == 0) {
                stash.push(val);
            } else if (val == 1) {
                if (stash.size() < 1 || stash.peek() != 0) {
                    return false;
                }
                stash.push(val);
            } else {
                if (stash.size() < 2) {
                    return false;
                }
                int x = stash.pop(), y = stash.pop();
                if (x != 1 || y != 0) {
                    return false;
                }
            }
        }
        return stash.isEmpty();
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
        int[][] A = {{0,1,0,0,1,1,1,0,1,0,0,0,1,1,1,1,0,1,0,1,1,1,0,1,1,0,1,1,1,0},{1,1,1,0,1,1,1,
                0,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,0,1,1},{1,1,1,1,0,0,1,1,0,1,1,1,0,1,0,1,
                1,1,0,0,0,0,1,1,0,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,0,1,1,1,1,
                0,1,1,1,1},{1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0},{0,1,0,
                0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0,1,1,0,1,0,1,1,0,1,1},{1,1,1,0,0,1,1,1,1,1,1,1,
                0,0,0,0,1,1,0,0,1,1,1,1,1,1,1,1,0,1},{1,0,1,1,0,1,0,1,1,0,1,1,0,0,0,0,1,1,1,1,1,
                1,1,1,1,1,0,1,1,1},{1,1,0,1,0,0,0,1,1,0,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0},
                {0,0,1,1,0,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1},{0,1,1,0,1,0,1,1,0,
                1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1},{0,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,
                1,1,1,1,1,0,1,0,0,1,1,1},{1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,
                1,1,0},{1,1,0,0,1,1,1,1,1,0,1,1,0,1,1,0,0,1,0,0,1,1,0,1,0,1,1,1,1,1},{1,1,1,1,1,
                1,1,0,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,1,1},{1,1,1,1,1,1,1,1,1,0,0,1,1,1,
                1,1,1,1,0,1,0,0,1,1,1,0,0,0,1,1},{1,1,1,1,1,1,0,0,0,1,0,1,1,0,1,1,0,1,1,1,1,0,1,
                1,1,1,1,1,1,0},{1,1,0,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,0,1,1,1,1,1,1,0,1,1,1,0},{1,
                1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,1,1},{1,1,1,1,1,1,0,0,1,1,
                0,1,1,1,1,1,0,0,0,1,0,1,1,0,1,1,1,1,1,0},{0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,
                0,1,0,1,0,1,1,1,1,0,1},{1,1,1,1,0,0,0,0,1,1,0,0,0,1,0,0,1,1,1,0,1,1,1,0,1,1,0,0,
                1,1},{1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,0,0,1,1,1,0,1,1,1,1},{1,0,0,1,1,1,
                1,1,1,1,1,0,1,0,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1},{1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,
                1,0,1,1,0,1,0,0,1,1,1,1,1,0,1},{0,1,0,1,0,1,0,1,1,1,1,1,1,0,1,1,0,0,1,0,1,1,1,0,
                0,1,1,1,1,1},{1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1},{1,0,
                0,1,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1},{1,0,1,1,1,1,1,1,1,0,1,
                1,1,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1},{1,1,1,0,0,0,1,1,0,1,0,0,1,1,1,0,1,1,1,1,
                1,1,1,1,1,1,1,1,0,1}};
        int[][] B =
                {{1,1,1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,1,1},{1,1,1,1,1,1, 1,1,1,1,1,0,0,1,1,1,0,1,0,1,0,0,1,0,1,1,1,1,1,1},{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},{1,1,1,1,1,1,1,1,1,0,0,1,1,0,1,0,0,0,1,1,0,0,1,1,1,0,1,1,1,0},{1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,1,1},{1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1},{0,0,1,1,0,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1},{0,0,0,0,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1},{1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,0,1,1,1,1,1},{1,1,0,1,0,0,1,1,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0,1},{1,0,1,0,0,1,1,0,0,1,1,1,1,1,1,0,0,1,0,1,1,0,1,0,1,0,0,0,1,0},{1,1,0,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1},{1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1},{1,0,0,1,1,1,0,1,1,0,0,1,1,1,0,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1},{1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,1,1,0,1},{0,1,0,0,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,1},{1,1,0,0,0,1,0,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,0,0,1,1,0,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,0,1,1},{1,0,0,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1},{1,0,0,1,0,0,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,0,1,1,1,0,1,0,1},{1,1,1,1,1,0,0,1,0,0,1,0,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,1,1,1},{0,0,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0,0},{1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,1,0,0,1,1},{1,0,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,1,1,0,1,1,1},{0,1,1,1,0,1,0,0,0,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1},{1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,1,0},{1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1},{1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1,0,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},{0,1,0,0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0}};
//        System.out.println(solution.largestOverlap(A, B));
        String str = "abcabcababcc";
        System.out.println(solution.isValid(str));
    }
}
