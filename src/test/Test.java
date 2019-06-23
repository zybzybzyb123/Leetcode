//CHECKSTYLE:OFF
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public List<List<Integer>> subsets(int[] nums) {
        if(null == nums || 0 == nums.length){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //先添加空集
        result.add(new ArrayList<>());
        for(int num : nums){
            int size = result.size();
            for(int i = 0; i < size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }

    public void reverseList(int N){
        ListNode head = new ListNode(0), first = head;
        //构造链表
        for(int i = 1; i <= N; i ++){
            ListNode node = new ListNode(i);
            node.next = head.next;
            head.next = node;
            head = node;
        }
        head = first.next;
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
        /**
         * 三指针法
         */
        head = first.next;
        ListNode node1 = head.next;
        ListNode node2 = node1.next;
        head.next = null;
        while(node2 != null){
            node1.next = head;
            head = node1;
            node1 = node2;
            node2 = node2.next;
        }
        //最后会单一个节点
        node1.next = head;
        head = node1;
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[][] dp = new long[25][25];
        dp[1][1] = 1;
        int x = scanner.nextInt() + 1, y = scanner.nextInt() + 1, n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            dp[scanner.nextInt() + 1][scanner.nextInt() + 1] = -1;
        }
        for (int i = 1; i <= x ; i++) {
            for (int j = 1; j <= y; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
//        for (int i = 1; i <= x; i++) {
//            for (int j = 1; j <= y; j++) {
//                System.out.format("dp[%d][%d]=%d ", i, j, dp[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(dp[x][y]);
    }
}
