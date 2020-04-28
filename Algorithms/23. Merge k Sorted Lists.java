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
    //优先队列解法
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode pHead = new ListNode(0), head = pHead;
        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
            if (head.next != null) {
                pq.offer(head.next);
            }
        }
        return pHead.next;
    }


    //直接合并多路链表
    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        }
        list2.next = merge(list1, list2.next);
        return list2;
    }

    private ListNode mergeHelper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode list1 = mergeHelper(lists, left, mid);
        ListNode list2 = mergeHelper(lists, mid + 1, right);
        return merge(list1, list2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }
}