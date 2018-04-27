/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(null == head) return null;
        //pre表示前一个节点
        ListNode pHead = head, pre = null;
        while(head != null){
            if(head.val == val){
                if(null == pre){
                    //头结点直接更新pHead
                    pHead = pHead.next;
                } else{
                    //将前节点与下一个节点连接
                    pre.next = head.next;
                }
            } else{
                //保存前节点，注意相等时不用更新
                pre = head;
            }
            head = head.next;
        }
        return pHead;
    }
}