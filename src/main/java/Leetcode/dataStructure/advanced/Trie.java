package Leetcode.dataStructure.advanced;

/**
 * @author zero
 * @created 2020/04/29
 * dictionary tree
 */
public class Trie {

    private TrieNode root;

    static class TrieNode {
        private char val;
        private boolean isWord;
        private TrieNode[] leafs;

        public TrieNode(char val) {
            this.val = val;
            this.leafs = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('a');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode[] temp = root.leafs;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            int pos = ch - 'a';
            if (temp[pos] == null) {
                temp[pos] = new TrieNode(ch);
            }
            if (i == len - 1) {
                temp[pos].isWord = true;
            }
            temp = temp[pos].leafs;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode[] temp = root.leafs;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            int pos = ch - 'a';
            if (temp[pos] == null
                    || (i == len - 1
                    && temp[pos].isWord == false)) {
                return false;
            }
            temp = temp[pos].leafs;
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode[] temp = root.leafs;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char ch = prefix.charAt(i);
            int pos = ch - 'a';
            if (temp[pos] == null) {
                return false;
            }
            temp = temp[pos].leafs;
        }
        return true;
    }
}