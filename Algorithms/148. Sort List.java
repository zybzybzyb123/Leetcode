/**
 * 归并排序 7ms
 * 快速排序 236ms
 */
class Solution {
    // merge sort
    private ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        }
        l2.next = mergeList(l1, l2.next);
        return l2;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 要断链
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeList(left, right);
    }

    // quickSort
    private void quickSort(ListNode begin, ListNode end) {
        if (begin == end || begin.next == end) {
            return;
        }
        ListNode p1 = begin, p2 = begin.next;
        int target = begin.val;
        while (p2 != end) {
            if (p2.val < target) {
                p1 = p1.next;
                int temp = p2.val;
                p2.val = p1.val;
                p1.val = temp;
            }
            p2 = p2.next;
        }
        int temp = p1.val;
        p1.val = begin.val;
        begin.val = temp;
        quickSort(begin, p1);
        quickSort(p1.next, end);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        quickSort(head, null);
        return head;
    }
}