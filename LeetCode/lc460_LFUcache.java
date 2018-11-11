// 460. LFU Cache
// I am using 2 map and 2 linkedlist
// not optimal, see https://leetcode.com/problems/lfu-cache/discuss/94521/JAVA-O(1)-very-easy-solution-using-3-HashMaps-and-LinkedHashSet

class LFUCache {
    class Node {
        int key;
        int value; 
        int freq;
        Node prev;
        Node next;
        Node(int k, int v) {
            key = k; value = v; freq = 0;
        }
    }
    class FreqNode {
        int freq;
        FreqNode prev;
        FreqNode next;
        Node head;
        Node tail;
        FreqNode(int f) { 
            freq = f; 
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }
    }
    Map<Integer, FreqNode> freqTable;
    Map<Integer, Node> map;
    FreqNode least;
    FreqNode most;
    int cap;
    int size;
    public LFUCache(int capacity) {
        freqTable = new HashMap<>();
        map = new HashMap<>();
        least = new FreqNode(0);
        most = new FreqNode(Integer.MAX_VALUE);
        least.next = most;
        most.prev = least;
        freqTable.put(0, least);
        freqTable.put(most.freq, most);
        cap = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            addToFreqNode(map.get(key));
            return map.get(key).value;
        }
        return -1; 
    }
    
    public void put(int key, int value) {
        Node cur = map.getOrDefault(key, new Node(key, value));
        if (!map.containsKey(key)) {
            if (size >= cap) {
                // remove the least
                FreqNode l = least.next;
                if (l == most) return;
                // remove first node in l
                int k = removeValueNode(l.head.next, l.head, l.tail, l.freq);
                map.remove(k);
                size --;
            }
            map.put(key, cur);
            addToFreqNode(cur);
            size ++;
        } else {
            cur.value = value;
            addToFreqNode(cur);
        }
    }
    
    private void addToFreqNode(Node n) {
        n.freq ++;
        FreqNode newFreq = freqTable.getOrDefault(n.freq, new FreqNode(n.freq));
        FreqNode p = freqTable.get(n.freq - 1);
        if (!freqTable.containsKey(n.freq)) {
            freqTable.put(n.freq, newFreq);
            // insert to the list of FreqNodes
            newFreq.next = p.next;
            newFreq.prev = p;
            p.next.prev = newFreq;
            p.next = newFreq;
        }
        if (p.freq > 0) {
            // remove n from old list
            int k = removeValueNode(n, p.head, p.tail, p.freq);
        }
        // add n to new list
        addToTail(n, newFreq.tail);
    }
    
    private int removeValueNode(Node n, Node head, Node tail, int freq) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        // no nodes of that frequency
        if (head.next == tail) removeFreqNode(freqTable.get(freq));
        return n.key;
    }
    
    private void addToTail(Node n, Node tail) {
        n.prev = tail.prev;
        n.next = tail;
        tail.prev.next = n;
        tail.prev = n;
    }
    
    private void removeFreqNode(FreqNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        freqTable.remove(n.freq);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */