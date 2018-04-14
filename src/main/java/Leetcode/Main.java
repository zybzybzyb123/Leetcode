package Leetcode;

import java.util.*;

/**
 * Created by ZUOYANBIN1 on 2017/9/18.
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        Boolean[] vis = new Boolean[100];
        Queue<Integer> queue = new LinkedList<>();
        boolean colour = false;
        queue.add(0);
        while(!queue.isEmpty()){
            int var = queue.poll();
            if(vis[var] == null){
                vis[var] = colour;
                colour = !colour;
                for(int i = 0; i < graph[var].length; i++){
                    if(vis[graph[var][i]] == null){
                        vis[graph[var][i]] = colour;
                        queue.add(graph[var][i]);
                    } else{
                        if(vis[graph[var][i]] != colour){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ans = 0;
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                long var = sum[j] - sum[i] + nums[i];
                if(var >= lower && var <= upper){
                    ans++;
                }
            }
        }
        return ans;
    }
    long[] res = new long[]{5,25,125,625,3125,15625,78125,390625,1953125,9765625,48828125,244140625,1220703125,6103515625L};
    long[] sum = new long[]{1,6,31,156,781,3906,19531,97656,488281,2441406,12207031,61035156,305175781,1525878906,7629394531L};
    public int preimageSizeFZF(int K) {
        if(K == 0) return 5;
        if(K % 5 == 0) return 0;
        sum[0] = 1;
        for (int i = 0; i < res.length; i++) {
            sum[i + 1] = res[i] + sum[i];
        }
        for(long val : sum){
            System.out.print(val + ",");
        }
        return 5;
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
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream("in.txt");
//        System.setIn(file);
        Solution solution = new Solution();
        System.out.println(solution);
    }
}
