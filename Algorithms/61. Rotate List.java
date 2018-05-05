/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 简单链表旋转，对于长度len的链表，将前len - (k % len)
 * 拼接到链表尾，保留链表头结点，链表尾节点和链表中间的节点
 * 以及他的前一个节点(因为要让这个节点指向null)的位置信息，
 * 之后拼成一个新的链表就OK了
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(null == head) return null;
        ListNode pHead = head, tail = head;
        int len = 0;
        while(pHead != null){
            len++;
            tail = pHead;
            pHead = pHead.next;
        }
        k %= len;
        if(k == 0) return head;
        k = len - k;
        pHead = head;
        //旋转之后的链表尾节点
        ListNode pre = head;
        while(k > 0){
            k--;
            pre = pHead;
            pHead = pHead.next;
        }
        //记录链表头结点，方便拼接
        ListNode node = head;
        //新的链表头节点
        head = pHead;
        //旧的链表尾与旧的头节点拼接(旋转的效果)
        tail.next = node;
        //新的链表尾节点指向null
        pre.next = null;
        return head;
    }
}