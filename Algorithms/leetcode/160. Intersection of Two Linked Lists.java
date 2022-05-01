/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * 题做多了还是有效果，自己想了想就想出了O(1)空间复杂度的解法
 * 先求两个链表的长度，已短链表为准，每一次移动一个一步，如果
 * 相交一定第一个相同的节点就是交点
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB) return null;
        int cnt1 = 0, cnt2 = 0;
        ListNode pHeadA = headA, pHeadB = headB;
        //计算链表长度
        while(headA != null){
            cnt1++;
            headA = headA.next;
        }
        while(headB != null){
            cnt2++;
            headB = headB.next;
        }
        headA = pHeadA;
        headB = pHeadB;
        //长链表保证和短链表长度一致
        if(cnt1 < cnt2){
            for(int i = cnt1; i < cnt2; i++){
                headB = headB.next;
            }
        } else{
            for(int i = cnt2; i < cnt1; i++){
                headA = headA.next;
            }
        }
        //第一个相同节点就是交点
        ListNode ans = null;
        while(headA != null){
            if(headA == headB){
                ans = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return ans;
    }
}