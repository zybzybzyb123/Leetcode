class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(null == root) return new ListNode[k];
        ListNode[] ans = new ListNode[k];
        int cnt = 0;
        ListNode head = root;
        while(root != null){
            cnt++;
            root = root.next;
        }
        //per是平均每组的节点数， 比mod小的组多一个节点
        int per = cnt / k, mod = cnt % k;
        for(int i = 0; i < k; i++){
            //node每组的头结点，tail表示当前组最后一个节点
            ListNode node = head, tail = null;
            for(int j = 0; j < per; j++){
                tail = head;
                head = head.next;
            }
            if(i < mod){
                tail = head;
                head = head.next;
            }
            if(head == null){
                //head为null时可能最后一组还没有保存
                ans[i] = node;
                break;
            }
            tail.next = null;
            ans[i] = node;
        }
        return ans;
    }
}