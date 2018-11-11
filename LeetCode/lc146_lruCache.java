// LeetCode 146. LRU Cache

class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int k, int v) { key = k; val = v; }
    }
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int cap;
    int size= 0;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        tail.prev = head;
        head.next = tail;
        cap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            // put the node to the tail of the list
            remove(n);
            addToTail(n);
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            remove(cur);
            addToTail(cur);
        }
        else {
            if (size >= cap) {
                // delete least recently used item
                if (head.next == tail) return;
                Node n = head.next;
                remove(n);
                map.remove(n.key);
                size --;
            }
            Node cur = new Node(key, value);
            addToTail(cur);
            map.put(key, cur);
            size ++;
        }
    }
    
    private void addToTail(Node n) {
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
        n.next = tail;
    }
    
    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */