class Trie {
    private class TreeNode{
        Boolean isLeaf = false;
        public TreeNode[] node = new TreeNode[26];
    }

    TreeNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
        for(TreeNode treeNode : root.node){
            treeNode = new TreeNode();
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode head = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(head.node[pos] == null){
                head.node[pos] = new TreeNode();
            }
            head = head.node[pos];
        }
        head.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode head = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(head.node[pos] == null){
                return false;
            }
            head = head.node[pos];
        }
        return head.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode head = root;
        for(char ch : prefix.toCharArray()){
            int pos = ch - 'a';
            if(head.node[pos] == null){
                return false;
            }
            head = head.node[pos];
        }
        return true;
    }
}
