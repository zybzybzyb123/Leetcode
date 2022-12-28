/**
 * lruCache 针对尾节点有个小优化
 */

class LRUCache {
    private class Node {
        private Integer key;
        private Integer value;
        private Node prev;
        private Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
    private Map<Integer, Node> lruCache;
    private Node head, tail;
    private int capacity;
    private int size;
    public LRUCache(int capacity) {
        lruCache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    public int get(int key) {
        Node node = lruCache.get(key);
        if (node == null) {
            return -1;
        }
        // move head
        removeNode(node);
        addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (lruCache.containsKey(key)) {
            Node node = lruCache.get(key);
            node.value = value;
            removeNode(node);
            addHead(node);
        } else {
            Node node = new Node(key, value);
            if (size == capacity) {
                lruCache.remove(tail.prev.key);
                removeNode(tail.prev);
                addHead(node);
                lruCache.put(key, node);
            } else {
                size++;
                addHead(node);
                lruCache.put(key, node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class Main {

    public static void main(String[] args) throws IOException {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
