package test;

import java.util.*;

public class Test {
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
    public int movesToChessboard(int[][] board) {
        int N = board.length;

        // count[code] = v, where code is an integer
        // that represents the row in binary, and v
        // is the number of occurrences of that row
        Map<Integer, Integer> count = new HashMap();
        for (int[] row: board) {
            int code = 0;
            for (int x: row)
                code = 2 * code + x;
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k1 = analyzeCount(count, N);
        if (k1 == -1) return -1;

        // count[code], as before except with columns
        count = new HashMap();
        for (int c = 0; c < N; ++c) {
            int code = 0;
            for (int r = 0; r < N; ++r)
                code = 2 * code + board[r][c];
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k2 = analyzeCount(count, N);
        return k2 >= 0 ? k1 + k2 : -1;
    }

    public int analyzeCount(Map<Integer, Integer> count, int N) {
        // Return -1 if count is invalid
        // Otherwise, return number of swaps required
        if (count.size() != 2) return -1;

        List<Integer> keys = new ArrayList(count.keySet());
        int k1 = keys.get(0), k2 = keys.get(1);

        // If lines aren't in the right quantity
        if (!(count.get(k1) == N/2 && count.get(k2) == (N+1)/2) &&
                !(count.get(k2) == N/2 && count.get(k1) == (N+1)/2))
            return -1;
        // If lines aren't opposite
        if ((k1 ^ k2) != (1<<N) - 1)
            return -1;

        int Nones = (1 << N) - 1;
        int ones = Integer.bitCount(k1 & Nones);
        int cand = Integer.MAX_VALUE;
        if (N%2 == 0 || ones * 2 < N) // zero start
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);

        if (N%2 == 0 || ones * 2 > N) // ones start
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);

        return cand;
    }
}
