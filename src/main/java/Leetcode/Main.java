//CHECKSTYLE:OFF
package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zero on 2017/9/18.
 */
class Solution {
    private int[] num = new int[20];
    public void init(int N) {
        num[1] = 1;
        for (int i = 1; i <= N; i += 2) {
            for (int j = 1; j < i; j += 2) {
                num[i] += num[j] * num[i - 1 - j];
            }
        }
        System.out.println(num[N]);
    }
    public List<TreeNode> allPossibleFBT(int N) {
        if ((N & 1) == 0) return new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> list1 = allPossibleFBT(i);
            List<TreeNode> list2 = allPossibleFBT(N - 1 - i);
            for (TreeNode left : list1) {
                for (TreeNode right : list2) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
        int n = 19;
        System.out.println(solution.allPossibleFBT(n).size());
    }
}
