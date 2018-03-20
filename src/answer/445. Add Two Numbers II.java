/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int flag = 0, var, var1, var2;
        while(l1 != null){
            list1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            list2.push(l2.val);
            l2 = l2.next;
        }
        while(!list1.isEmpty() && !list2.isEmpty()){
            var1 = list1.pop();
            var2 = list2.pop();
            var = (var1 + var2 + flag) % 10;
            flag = (var1 + var2 + flag) / 10;
            ListNode node = new ListNode(var);
            node.next = list.next;
            list.next = node;
        }
        while(!list1.isEmpty() || !list2.isEmpty()){
            if(!list1.isEmpty()){
                var1 = list1.pop();    
            } else{
                var1 = list2.pop();
            }
            var = (var1 + flag) % 10;
            flag = (var1 + flag) / 10;
            ListNode node = new ListNode(var);
            node.next = list.next;
            list.next = node;
        }
        if(flag == 1){
            ListNode node = new ListNode(1);
            node.next = list.next;
            list.next = node;
        }
        return list.next;
    }
}