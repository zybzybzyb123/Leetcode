/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 自己也是用的优先队列，不过加了一个pos变量
 * 看讨论区发现这个变量可以去掉，就修改了下，
 * 可以直接使用lists的引用，避免new节点
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists) return null;
        ListNode head = new ListNode(0);
        ListNode pHead = head;
        Queue<ListNode> pq = new PriorityQueue<>
                ((o1, o2) -> o1.val - o2.val);
//        int sz = 0;
        for(ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }
        while(!pq.isEmpty()){
            pHead.next = pq.poll();;
            pHead = pHead.next;
            if(pHead.next != null){
                pq.offer(pHead.next);
            }
        }
        return head.next;
    }
}