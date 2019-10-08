package Leetcode;

import Leetcode.dataStructure.base.ListNode;
import Leetcode.dataStructure.base.Node;
import Leetcode.dataStructure.base.TreeNode;

import java.util.*;

class Solution {

    // 并查集
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        return s;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (pre == null) {
                    pre = temp;
                } else {
                    pre.next = temp;
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return root;
    }
}


public class Main {

    public static void main(String[] args) {
        // FileInputStream file = new FileInputStream('in.txt');
        // System.setIn(file);
        Solution solution = new Solution();
        // String s = "cba";
        // int[][] array = {{0,1},{1,2}};
        // List<List<Integer>> pairs = new ArrayList<>();
        // for (int[] val : array) {
        // pairs.add(Arrays.asList(val[0], val[1]));
        // }
        // System.out.println(solution.smallestStringWithSwaps(s, pairs));
        String s = "ababacb";
        int k = 3;
        System.out.println(solution);
    }

}
