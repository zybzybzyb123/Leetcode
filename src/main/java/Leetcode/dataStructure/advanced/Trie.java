package Leetcode.dataStructure.advanced;

public class Trie {

    private class TrieNode {
        Boolean isLeaf = false;
        public TrieNode[] nodes = new TrieNode[26];
    }

    TrieNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode head = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(head.nodes[pos] == null){
                head.nodes[pos] = new TrieNode();
            }
            head = head.nodes[pos];
        }
        head.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode head = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(head.nodes[pos] == null){
                return false;
            }
            head = head.nodes[pos];
        }
        return head.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for(char ch : prefix.toCharArray()){
            int pos = ch - 'a';
            if(head.nodes[pos] == null){
                return false;
            }
            head = head.nodes[pos];
        }
        return true;
    }
}