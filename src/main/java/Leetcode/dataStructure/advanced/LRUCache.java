package Leetcode.dataStructure.advanced;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    
    private class Node {
        private K key;
        private V val;
        private Node pre, next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public Node() {}
    }

    private Map<K, Node> lruCache;
    private Node head, tail;
    private int curSize, maxSize;

    private void addTail(Node node) {
        curSize++;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
        node.pre.next = node;
    }

    private void removeNode (Node node) {
        curSize--;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    public LRUCache(int capacity) {
        curSize = 0;
        maxSize = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        lruCache = new HashMap<>();
    }

    public V get(K key) {
        Node node = lruCache.get(key);
        if (node == null) {
            return null;
        }
        if (node.next != tail) {
            removeNode(node);
            addTail(node);
        }
        return node.val;
    }
    
    public void put(K key, V value) {
        Node node = lruCache.get(key);
        if (node != null) {
            removeNode(node);
            lruCache.remove(key);
        }
        if (curSize >= maxSize) {
            lruCache.remove(head.next.key);
            removeNode(head.next);
        }
        Node newNode = new Node(key, value);
        addTail(newNode);
        lruCache.put(key, newNode);
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}