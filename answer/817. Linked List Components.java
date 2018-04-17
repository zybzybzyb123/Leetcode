/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 这个题类似并查集的概念,每个新值都找到满足条件的链
 *
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        //pos[0]表示前一个节点的值, pos[1]表示后一个节点的值
        int[][] pos = new int[10005][2];
        for(int i = 0; i < pos.length; i++){
            for(int j = 0; j < 2; j++){
                pos[i][j] = -1;
            }
        }
        //1表示已经使用,-1表示未使用(注意0是代表这个值未出现)
        int[] vis = new int[10005];
        int ans = 0;
        ListNode pHead = head;
        ListNode pre = null;
        while(head != null){
            if(pre != null){
                pos[head.val][0] = pre.val;
            }
            if(head.next != null){
                pos[head.val][1] = head.next.val;
            }
            pre = head;
            head = head.next;
        }
        for(int i = 0; i < G.length; i++){
            vis[G[i]] = -1;
        }
        for(int i = 0; i < G.length; i++){
            if(vis[G[i]] == 1) continue;
            vis[G[i]] = -1;
            int preVal = pos[G[i]][0], nextVal = pos[G[i]][1];
            ans++;
            //找到链表前一个节点的关系
            while(preVal != -1 && vis[preVal] == -1){
                vis[preVal] = 1;
                preVal = pos[preVal][0];
            }
            //找到链表后一个节点的关系
            while(nextVal != -1 && vis[nextVal] == -1){
                vis[nextVal] = 1;
                nextVal = pos[nextVal][1];
            }
        }
        return ans;
    }
}