/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(null == head) return null;
        if(head.next == null) return head;
        //odd奇数链表，even是偶数链表
        ListNode odd = head, even = head.next,  pEven = even, oddPre = null, evenPre = null;
        while(odd != null){
            if(oddPre != null){
                oddPre.next = odd;
            }
            if(evenPre != null){
                evenPre.next = pEven;
            }
            if(pEven == null) break;
            oddPre = odd;
            evenPre = pEven;
            odd = pEven.next;
            if(odd != null){
                pEven = odd.next;
            }
        }
        //这根据链表长度是单还是双作不同处理
        if(odd != null){
            odd.next = even;
        } else{
            oddPre.next = even;
        }
        return head;
    }
}