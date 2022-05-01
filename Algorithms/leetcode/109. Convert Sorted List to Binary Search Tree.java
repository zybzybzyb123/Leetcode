/**
 * 取链表中间节点,然后就是无脑递归
 */
class Solution {
    //用数组保存解法 (2ms)
    private TreeNode createTree(List<Integer> list, int left, int right){
        if(left == right) return null;
        if (left == right - 1) {
            return new TreeNode(list.get(left));
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = createTree(list, left, mid);
        root.right = createTree(list, mid + 1, right);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(null == head) return null;
        ListNode pHead = head;
        List<Integer> list = new ArrayList<>();
        while(pHead != null){
            list.add(pHead.val);
            pHead = pHead.next;
        }
        TreeNode root = createTree(list, 0, list.size());
        return root;
    }

    //快慢指针 1ms
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}