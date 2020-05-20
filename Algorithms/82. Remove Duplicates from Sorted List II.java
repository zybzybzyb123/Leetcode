/**
 * 加个状态标志
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pHead = new ListNode(-1), first = pHead;
        boolean isDuplicate = false;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                isDuplicate = true;
            } else if (isDuplicate) {
                isDuplicate = false;
            } else {
                pHead.next = head;
                pHead = head;
            }
            head = head.next;
        }
        pHead.next = null;
        return first.next;
    }
}