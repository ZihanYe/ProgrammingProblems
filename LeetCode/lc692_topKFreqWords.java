// LeetCode 692. Top K Frequent Words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String a, String b) {
                int diff = freq.getOrDefault(a,0) - freq.getOrDefault(b,0);
                return diff==0? b.compareTo(a) : diff;
            }
        });
        
        for (Map.Entry<String, Integer> e: freq.entrySet()) {
            if (pq.size() < k) pq.offer(e.getKey());
            else {
                String first = pq.peek();
                int f = freq.getOrDefault(first,0);
                if (f < e.getValue() || (f==e.getValue() && first.compareTo(e.getKey()) > 0)) {
                    String drop = pq.poll();
                    pq.offer(e.getKey());
                }
            }
        }
        // addd to list
        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            String s = pq.poll();
            res.offerFirst(s);
        }
        return res;
    }
}