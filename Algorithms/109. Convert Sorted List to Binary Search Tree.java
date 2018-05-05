/**
 * 就是一顿无脑递归建树就AC了，看通过率还以为有啥坑呢，
 * 事实告诉我并没有(快慢指针居然比我用数组定位要快。。。)
 */
class Solution {
    private TreeNode createTree(List<Integer> list, int left, int right){
        if(left == right) return null;
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
}