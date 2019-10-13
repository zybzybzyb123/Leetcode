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


    private static final List<Integer> emptyList = Collections.EMPTY_LIST;
    private List<Integer> getNumbers(int num) {
        if (num == 0) {
            return Arrays.asList(0);
        }
        List<Integer> ans = new ArrayList<>();
        while (num > 0) {
            ans.add(num % 10);
            num /= 10;
        }
        return ans;
    }
    private List<Integer> judge(int first, int second, char[] array, int begin) {
        if (first > Integer.MAX_VALUE - second) {
            return emptyList;
        }
        int end = array.length;
        List<Integer> ans = new ArrayList<>();
        ans.addAll(Arrays.asList(first, second));
        while (first <= Integer.MAX_VALUE - second && begin < end) {
            int third = first + second;
            List<Integer> nums = getNumbers(third);
            if (begin + nums.size() > end) {
                return emptyList;
            }
            for (int i = begin + nums.size() - 1; i >= begin ; i--) {
                if (array[i] - '0' != nums.get(begin + nums.size() - 1 - i)) {
                    return emptyList;
                }
            }
            begin = begin + nums.size();
            //
            ans.add(third);
            first = second;
            second = third;
        }
        return begin == end && ans.size() > 2 ? ans : emptyList;
    }
    public List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() == 0) {
            return emptyList;
        }
        List<Integer> ans = new ArrayList<>();
        int first = 0;
        char[] array = S.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int num1 = array[i] - '0';
            if (first > Integer.MAX_VALUE / 10 || (first == Integer.MAX_VALUE / 10 && num1 > 0)) {
                break;
            }
            first = first * 10 + num1;
            int second = 0;
            for (int j = i + 1; j < array.length; j++) {
                int num2 = array[j] - '0';
                if (second >= Integer.MAX_VALUE / 10  || (second == Integer.MAX_VALUE / 10 && num2 > 0)) {
                    break;
                }
                second = second * 10 + num2;
                ans = judge(first, second, array, j + 1);
                if (ans.size() > 0) {
                    return ans;
                }
                if (second == 0) {
                    break;
                }
            }
            if (first == 0) {
                break;
            }
        }
        return ans;
    }

    public String multiply(String num1, String num2) {
        int[] num = new int[num1.length() + num2.length() + 1];
        for (int i = 0; i < num1.length(); i++) {
            int val1 = num1.charAt(num1.length() - 1 - i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int val2 = num2.charAt(num2.length() - 1 - j) - '0';
                num[i + j] += val1 * val2;
            }
        }
        int flag = 0;
        for (int i = 0; i < num.length; i++) {
            int val = num[i] + flag;
            num[i] = val % 10;
            flag = val / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = num.length - 1; i >= 0 ; i--) {
            if (num[i] > 0) {
                for (int j = i; j >= 0 ; j--) {
                    sb.append(num[j]);
                }
                return sb.toString();
            }
        }
        return "0";
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = new ListNode(0), beforeCur = before, after = new ListNode(0), afterCur = after;
        while (head != null) {
            if (head.val < x) {
                beforeCur.next = head;
                beforeCur = beforeCur.next;
            } else {
                afterCur.next = head;
                afterCur = afterCur.next;
            }
            head = head.next;
        }
        beforeCur.next = after;
        return before.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        for (int i = 0; i < m; i++) {
            head = head.next;
        }
        ListNode first = null, second = head;
        while (second != null && m < n) {
            ListNode third = second.next;
            second.next = first;
            first = second;
            second = third;
            m++;
        }
        head.next = second;
        return pHead.next;
    }

    public int balancedStringSplit(String s) {
        int[] cnt = new int[2];
        int ans = 0;
        for (char ch : s.toCharArray()) {
            cnt[ch == 'L' ? 0 : 1]++;
            if (cnt[0] == cnt[1]) {
                ans++;
            }
        }
        return ans;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        if (queens.length == 0) {
            return Collections.EMPTY_LIST;
        }
        boolean[][] vis = new boolean[8][8];
        for (int[] queen : queens) {
            vis[queen[0]][queen[1]] = true;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int x = king[0] + i, y = king[1] + j;
                while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (vis[x][y]) {
                        ans.add(Arrays.asList(x, y));
                        break;
                    }
                    x += i;
                    y += j;
                }
            }
        }
        return ans;
    }
}


public class Main {

    public static void main(String[] args) {
        // FileInputStream file = new FileInputStream('in.txt');
        // System.setIn(file);
        Solution solution = new Solution();
        int n = 3;
        int[] rollMax = {1,1,1,2,2,3};
        System.out.println(solution);
    }
}
