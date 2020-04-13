/**
 * 添加递归解法比较经典
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

    // 递归解法
    private int flag = 0;
    private int count(ListNode listNode) {
        int cnt = 0;
        while (listNode != null) {
            cnt++;
            listNode = listNode.next;
        }
        return cnt;
    }
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int cnt1, int cnt2) {
        if (cnt1 > cnt2) {
            l1.next = addTwoNumbers(l1.next, l2,  cnt1 - 1, cnt2);
            int val = l1.val + flag;
            l1.val = val % 10;
            flag = val / 10;
            return l1;
        }  else {
            if (cnt1 > 1) {
                l1.next = addTwoNumbers(l1.next, l2.next,  cnt1 - 1, cnt2 - 1);
                int val = l1.val + l2.val + flag;
                l1.val = val % 10;
                flag = val / 10;
                return l1;
            } else {
                int val = l1.val + l2.val + flag;
                l1.val = val % 10;
                flag = val / 10;
                return l1;
            }
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cnt1 = count(l1);
        int cnt2 = count(l2);
        l1 = cnt1 > cnt2 ? addTwoNumbers(l1, l2, cnt1, cnt2) : addTwoNumbers(l2, l1, cnt2, cnt1);
        if (flag == 1) {
            ListNode ans = new ListNode(1);
            ans.next = l1;
            return ans;
        }
        return l1;
    }
}