/**
 * lruCache 针对尾节点有个小优化
 */

class LRUCache {

    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;
        private Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> lruCache;
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        lruCache = new HashMap<>(capacity);
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
        size--;
        lruCache.remove(node.key);
    }

    private void addNode(Node node) {
        node.next = tail;
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        size++;
        lruCache.put(node.key, node);
    }

    public int get(int key) {
        Node node = lruCache.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {
            removeNode(node);
            addNode(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = lruCache.get(key);
        if (node == null) {
            node = new Node(key, value);
            addNode(node);
            if (size > capacity) {
                removeNode(head.next);
            }
        } else {
            node.value = value;
            if (node == tail) {
                return;
            }
            removeNode(node);
            addNode(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */