/**
 * 链表相加，直接用的前一个链表处理的
 * pre和preL2分别是链表1和2的当前节点的前一个节点
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head1 = l1, pre = null;
        int flag = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + flag;
            l1.val = temp % 10;
            flag = temp / 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null && flag != 0) {
                int temp = l1.val + flag;
                l1.val = temp % 10;
                flag = temp / 10;
                pre = l1;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            //l1和l2连接的位置
            ListNode node = l2;
            ListNode preL2 = null;
            while (l2 != null && flag != 0) {
                int temp = l2.val + flag;
                l2.val = temp % 10;
                flag = temp / 10;
                preL2 = l2;
                l2 = l2.next;
            }
            //l2有进位
            if (flag != 0) {
                preL2.next = new ListNode(1);
                flag = 0;
            }
            //l1和l2拼接
            pre.next = node;
        }
        //l1有进位
        if (flag != 0) {
            pre.next = new ListNode(1);
        }
        return head1;
    }
}