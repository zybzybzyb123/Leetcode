/**
 * 链表反转之前一直用的三指针法，这次终于把递归写法搞懂了
 * 关键就是一个顺序问题，需要先递归之后再执行上一个节点和
 * 当前节点的指针修改这样才能保证指向null的指针只在头结点生效
 */
class Solution {
    //递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pHead = reverseList(head.next);
        head.next.next = head;
        //这个指向null会在上一个节点的head.next.next = head被消除，只有头结点会指向null
        head.next = null;
        return pHead;
    }

    //非递归两个指针
    public ListNode reverseList(ListNode head) {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode first = null, second = head;
            while (second != null) {
                ListNode third = second.next;
                second.next = first;
                first = second;
                second = third;
            }
            return first;
        }
    }
}